package mybatis.example.domain.person;

import mybatis.example.Mapper;
import mybatis.example.ResultMapper;
import mybatis.example.SelectResultProvider;
import mybatis.example.handle.BaseHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-11 11:12
 */
@Repository
public interface PersonMapper extends Mapper<Person>, ResultMapper<Person> {

    @Select("select  * from person u where u.id = #{id}")
    @Results(id = "personResultMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "status", column = "status", typeHandler = BaseHandler.class),
                    @Result(property = "role", column = "role", typeHandler = BaseHandler.class),
                    @Result(property = "countryId", column = "country_id"),
                    @Result(property = "country",
                            column = "country_id",
                            one = @One(select = "mybatis.example.domain.country.CountryMapper.selectByPrimaryKey", fetchType = FetchType.EAGER))
                    ,
                    @Result(property = "personAddresses",
                            column = "id",
                            many = @Many(select = "mybatis.example.domain.addres.PersonAddressMapper.selectByUserId", fetchType = FetchType.EAGER))
            }
    )
    Person getPersonById(@Param("id") Long id);


    @ResultMap("personResultMap")
    @SelectProvider(type = SelectResultProvider.class, method = "dynamicSQL")
    List<Person> selectByExample2Result(Object example);


}
