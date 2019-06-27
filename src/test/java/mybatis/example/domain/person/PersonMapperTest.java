package mybatis.example.domain.person;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mybatis.example.AppExample;
import mybatis.example.FiledHelper;
import mybatis.example.domain.addres.PersonAddress;
import mybatis.example.domain.addres.PersonAddressMapper;
import mybatis.example.domain.country.Country;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendSqls;
import tk.mybatis.mapper.weekend.reflection.Reflections;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-11 11:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppExample.class)
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;
    @Resource
    private PersonAddressMapper personAddressMapper;
    @Resource
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void selectAll() {
        List<Person> list = personMapper.selectAll();
        Assert.notNull(list, "list is null");

        list.stream().forEach(c -> {
            System.err.println(c);
        });
    }

    @Test
    public void selectByExample2Result() {
        Weekend<Person> of = Weekend.of(Person.class);
        of.weekendCriteria()
                .andGreaterThan(Person::getAge, 1)
                .andLike(Person::getName, "%ndy%");
        List<Person> list = personMapper.selectByExample2Result(of);
        Assert.notNull(list, "list is null");
    }

    @Test
    public void selectByExample2() {
        Weekend<Person> of = Weekend.of(Person.class);
        of.weekendCriteria()
                .andGreaterThan(Person::getAge, 1)
                .andLike(Person::getName, "%ndy%");
        of.or(of.weekendCriteria()
                .andLessThan(Person::getAge, 1000));
        of.and(of.weekendCriteria()
                .andLessThan(Person::getCountryId, 10000)
                .andGreaterThan(Person::getCountryId, 1));
        List<Person> list = personMapper.selectByExample(of);
        Assert.isTrue(!list.isEmpty(), "list is null");
    }

    @Test
    public void selectByExample() {
        Weekend<Person> of = Weekend.of(Person.class);
        of.weekendCriteria()
                .andGreaterThan(Person::getAge, 1)
                .andLike(Person::getName, "%ndy%");
        List<Person> list = personMapper.selectByExample(of);
        Assert.isTrue(!list.isEmpty(), "list is null");
    }

    @Test
    public void weekendSqls() {
        Example example = Example.builder(Person.class)
                .select(FiledHelper.fieldName(Person::getId),
                        FiledHelper.fieldName(Person::getName),
                        FiledHelper.fieldName(Person::getCountryId))
                .where(WeekendSqls.<Person>custom()
                        .andLike(Person::getName, "%d%"))
                .orWhere(WeekendSqls.<Person>custom()
                        .andGreaterThan(Person::getCountryId, 1)
                        .andLessThanOrEqualTo(Person::getCountryId, 100))
                .build();
        List<Person> list = personMapper.selectByExample(example);
        Assert.isTrue(list.size() > 0, "list is null");
    }

    @Test
    public void page() {
        Example example = Example.builder(Person.class).build();
        Page<Person> list = PageHelper.startPage(1, 10)
                .doSelectPage(() -> personMapper.selectByExample2Result(example));
        Assert.isTrue(!list.isEmpty(), "list is null");
        list.stream().forEach(c -> {
            System.err.println(c);
        });
        System.out.println("list.getTotal()=" + list);
    }

    @Test
    public void page2() {
        PageHelper.startPage(1, 10);
        List<Person> list = personMapper.selectAll();
        Assert.isTrue(!list.isEmpty(), "list is null");
        list.stream().forEach(c -> {
            System.err.println(c);
        });
        System.out.println("list.getTotal()=" + list);
    }

    @Test
    public void getPersonById() {
        Person personById = personMapper.getPersonById(1l);
        Assert.notNull(personById, "personById is null");
        System.out.println(personById);
    }

    @Test
    public void test() {
        PersonMapper mapper = sqlSessionFactory.openSession().getMapper(PersonMapper.class);
        Weekend<Person> of = Weekend.of(Person.class);
        of.weekendCriteria()
                .andGreaterThan(Person::getAge, 1)
                .andLike(Person::getName, "%ndy%");
        mapper.selectByExample(of);
    }
}
