package mybatis.example.domain.addres;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: zscome
 * DateTime: 2019-06-11 20:17
 */
@ToString
@Data
@Table(name = "addres")
public class Addres implements Serializable {
    private static final long serialVersionUID = 6569081236403751407L;
    @Id
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long id;
    private String addres;


}
