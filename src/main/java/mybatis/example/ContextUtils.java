package mybatis.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: zscome
 * DateTime: 2019-04-11 11:54
 */
@Component
public class ContextUtils implements ApplicationContextAware {

    private static ConfigurableApplicationContext context;

    public static void setContext(ConfigurableApplicationContext context) {
        ContextUtils.context = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtils.context = (ConfigurableApplicationContext) applicationContext;


    }

    public static void autowireBean(Object bean) {
        context.getAutowireCapableBeanFactory().autowireBean(bean);
    }

    public static void registerBean(String beanName, Object obj) {
        context.getBeanFactory().registerSingleton(beanName, obj);

    }

    public static void createBean(Class clazz) {
        context.getBeanFactory().createBean(clazz);
    }



}
