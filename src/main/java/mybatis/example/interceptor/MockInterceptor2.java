package mybatis.example.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author: zscome
 * DateTime: 2019-06-18 20:16
 */
@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        }
)
public class MockInterceptor2 implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        invocation.getMethod().getName();
        System.err.println("=MockInterceptor2=>className=" + invocation.getTarget().getClass().getName() + ",getMethodName=" + invocation.getMethod().getName());
        Object proceed = invocation.proceed();
        System.err.println("<=MockInterceptor2=>className=" + invocation.getTarget().getClass().getName() + ",getMethodName=" + invocation.getMethod().getName());
        return proceed;
    }



    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        properties.forEach((k, v) -> System.err.println(k + "=" + v));
    }
}
