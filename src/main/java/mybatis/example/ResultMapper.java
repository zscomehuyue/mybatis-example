package mybatis.example;

import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-12 11:35
 */
@RegisterMapper
public interface ResultMapper<T> {

    @SelectProvider(type = SelectResultProvider.class, method = "dynamicSQL")
    List<T> selectByExample2Result(Object example);
}
