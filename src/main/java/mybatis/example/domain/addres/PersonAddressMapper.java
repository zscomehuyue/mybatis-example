package mybatis.example.domain.addres;

import mybatis.example.Mapper;
import mybatis.example.ResultMapper;
import mybatis.example.SelectResultProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-12 13:53
 */
@org.apache.ibatis.annotations.Mapper
public interface PersonAddressMapper extends Mapper<PersonAddress>, ResultMapper<PersonAddress> {

    @Results(id = "personAddressResultMap",
            value = {
                    @Result(property = "userId", column = "user_id"),
                    @Result(property = "addresId", column = "addres_id"),
                    @Result(property = "addres",
                            column = "addres_id",
                            one = @One(select = "mybatis.example.domain.addres.AddresMapper.selectByPrimaryKey", fetchType = FetchType.EAGER))
            }
    )
    @SelectProvider(type = SelectResultProvider.class, method = "dynamicSQL")
    List<PersonAddress> selectByExample2Result(Object example);

    @Select("select  * from person_addres u where u.user_id = #{userId}")
    @ResultMap("personAddressResultMap")
    List<PersonAddress> selectByUserId(@Param("userId") Long userId);
}
