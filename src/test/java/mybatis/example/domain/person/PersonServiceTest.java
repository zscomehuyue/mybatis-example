package mybatis.example.domain.person;

import mybatis.example.AppExample;
import org.apache.ibatis.type.BaseTypeHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author: zscome
 * DateTime: 2019-06-11 17:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppExample.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void getPersonById() {
        Person byId = personService.findById(1);
        Assert.notNull(byId,"is null");

        //resultSetHandler.<E>handleResultSets(statement)
    }
}
