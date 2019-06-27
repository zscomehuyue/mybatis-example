package mybatis.example;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author: zscome
 * DateTime: 2019-06-12 04:06
 * FIXME 1。通用加上注解RegisterMapper，会自动注册子类的成mapper；
 * FIXME 2。tk.mybatis.spring.annotation.MapperScan 不能扫描到有注解RegisterMapper的mapper；
 *
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface Mapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
