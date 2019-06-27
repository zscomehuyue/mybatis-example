package mybatis.example.domain.addres;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author: zscome
 * DateTime: 2019-06-12 13:52
 */
@ToString
@Data
@Table(name = "person_addres")
public class PersonAddress {
    @Id
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long id;
    private Integer userId;
    private Integer addresId;

    @Transient
    private Addres addres;
}
