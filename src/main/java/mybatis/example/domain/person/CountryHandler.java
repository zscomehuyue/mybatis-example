package mybatis.example.domain.person;

import mybatis.example.ContextUtils;
import mybatis.example.domain.country.Country;
import mybatis.example.domain.country.CountryMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: zscome
 * DateTime: 2019-06-11 16:48
 */
//@MappedJdbcTypes(JdbcType.BIGINT)
//@MappedTypes(value = {Country.class})
public class CountryHandler extends BaseTypeHandler<Country> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Country parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId().intValue());
    }

    @Override
    public Country getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumType(i);
        }
    }

    @Override
    public Country getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumType(i);
        }
    }

    @Override
    public Country getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return getEnumType(i);
        }
    }

    private Country getEnumType(int id) {
        Country country = new Country();
        country.setId(Long.valueOf(id));
        country = ContextUtils.getBean(CountryMapper.class).getCountryById(Long.valueOf(id));
        return country;
    }

}
