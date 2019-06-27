package mybatis.example;

import tk.mybatis.mapper.weekend.Fn;
import tk.mybatis.mapper.weekend.reflection.Reflections;

/**
 * @author: zscome
 * DateTime: 2019-06-13 21:03
 */
public class FiledHelper<T> {

    public static <T> String fieldName(Fn<T, Object> fn) {
        return Reflections.fnToFieldName(fn);
    }
}
