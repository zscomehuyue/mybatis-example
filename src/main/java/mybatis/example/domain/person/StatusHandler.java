package mybatis.example.domain.person;

import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import tk.mybatis.mapper.util.SimpleTypeUtil;

/**
 * @author: zscome
 * DateTime: 2019-05-20 11:27
 */
//@MappedJdbcTypes(JdbcType.INTEGER)
//@MappedTypes(value = {StatusEnum.class, AuthEnum.class})
public class StatusHandler extends EnumOrdinalTypeHandler<StatusEnum> {
    public StatusHandler(Class<StatusEnum> type) {
        super(type);
        SimpleTypeUtil.registerSimpleType(type);
        SimpleTypeUtil.registerSimpleType(AuthEnum.class);
    }
}
