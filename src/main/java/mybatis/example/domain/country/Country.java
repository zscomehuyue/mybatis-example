package mybatis.example.domain.country;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: zscome
 * DateTime: 2019-06-11 10:37
 */
@ToString
@Data
@Table(name = "country")
public class Country implements Serializable {
    private static final long serialVersionUID = 6569081236403751407L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer orderNum;
    private String name;
    private String code;


}
