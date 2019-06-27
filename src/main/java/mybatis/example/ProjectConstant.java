package mybatis.example;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "mybatis.example";//生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）

    public static final String MODEL_PACKAGE = BASE_PACKAGE;//生成的Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".domain";//生成的Model所在包
    public static final String HANDLE_PACKAGE = "mybatis.example.handle";//生成的Model所在包

    public static final String MAPPER_INTERFACE_REFERENCE = Mapper.class.getName();//Mapper插件基础接口的完全限定名


    public static void main(String args[]) {

        Type genericInterface = null;
        try {
            genericInterface = Class.forName("mybatis.example.ResultMapper",true,ProjectConstant.class.getClassLoader()).getGenericInterfaces()[0];
            ParameterizedType t = (ParameterizedType) genericInterface;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
