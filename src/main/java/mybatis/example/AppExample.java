package mybatis.example;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author: zscome
 * DateTime: 2019-06-11 10:42
 * FIXME 使用tk.mybatis.spring.annotation.MapperScan 进行扫描；
 */
@MapperScan(basePackages = "mybatis.example.domain")
@SpringBootApplication(exclude = {PageHelperAutoConfiguration.class})
public class AppExample {

    public static void main(String[] args) {
        SpringApplication.run(AppExample.class, args);
    }


}
