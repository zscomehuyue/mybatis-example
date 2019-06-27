package mybatis.example.handle;

import mybatis.example.domain.person.AuthEnum;
import mybatis.example.domain.person.EnumType;
import mybatis.example.domain.person.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author: zscome
 * DateTime: 2019-06-11 11:58
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = {StatusEnum.class, AuthEnum.class})
public class BaseHandler extends BaseTypeHandler<EnumType> {

    private Class<EnumType> types;

    public BaseHandler(Class<EnumType> types) {
        this.types = types;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public EnumType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumType(id);
        }
    }

    @Override
    public EnumType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumType(value);
        }
    }

    private EnumType getEnumType(int value) {
        try {
            Method valueOfType = Arrays.stream(types.getDeclaredMethods())
                    .filter(m -> m.getName().equals("valueOfType"))
                    .findFirst()
                    .orElse(null);
            return (EnumType) ReflectionUtils.invokeMethod(valueOfType, types.getEnumConstants()[0], value);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert to " + types.getName() + " by ordinal value.", ex);
        }
    }

    @Override
    public EnumType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return getEnumType(id);
        }
    }


}
