package mybatis.example.domain.person;

import mybatis.example.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zscome
 * DateTime: 2019-06-11 17:55
 */
@Service
public class PersonService extends BaseService<Person> {

    @Autowired
    private PersonMapper personMapper;

}

