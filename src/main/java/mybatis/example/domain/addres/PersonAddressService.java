package mybatis.example.domain.addres;

import mybatis.example.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-12 14:55
 */
public class PersonAddressService extends BaseService<PersonAddress> {

    @Autowired
    private PersonAddressMapper personAddressMapper;

    public List<PersonAddress> getPersonAddress(Long userId) {
        Weekend<PersonAddress> of = Weekend.of(PersonAddress.class);
        of.weekendCriteria().andEqualTo(PersonAddress::getUserId, userId);
        return personAddressMapper.selectByExample2Result(of);
    }
}
