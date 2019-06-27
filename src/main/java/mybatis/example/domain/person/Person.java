package mybatis.example.domain.person;

import lombok.Data;
import lombok.ToString;
import mybatis.example.domain.addres.PersonAddress;
import mybatis.example.domain.country.Country;
import mybatis.example.handle.BaseHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-11 11:10
 */
@Data
@ToString
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @ColumnType(typeHandler = BaseHandler.class)
    private StatusEnum status;

    @ColumnType(typeHandler = BaseHandler.class)
    private AuthEnum role;

    private Long countryId;

    @Transient
    private Country country;

    @Transient
    private List<PersonAddress> personAddresses;

}
