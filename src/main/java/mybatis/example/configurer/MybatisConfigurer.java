package mybatis.example.configurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import mybatis.example.interceptor.MockInterceptor;
import mybatis.example.interceptor.MockInterceptor2;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static mybatis.example.ProjectConstant.*;


/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("autoDialect", "true");//支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("closeConn", "true");//支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("autoRuntimeDialect", "true");//支持通过 Mapper 接口参数来传递分页参数
//        properties.setProperty("helperDialect", "hsqldb");//FIXME 支持通过 Mapper 接口参数来传递分页参数
//        properties.setProperty("dialect", "hsqldb");//FIXME 支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(properties);

        PageHelper pageHelper =new PageHelper();
        pageHelper.setProperties(properties);

        //添加插件
        Interceptor[] plugins = {pageInterceptor,new MockInterceptor(),new MockInterceptor2()};
        factory.setPlugins(plugins);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        SqlSessionFactory sessionFactory = factory.getObject();
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}

