package mybatis.example.domain.country;

import mybatis.example.AppExample;
import mybatis.example.domain.addres.Addres;
import mybatis.example.domain.addres.AddresMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: zscome
 * DateTime: 2019-06-11 10:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppExample.class)
public class CountryMapperTest {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private AddresMapper addresMapper;

    @Test
    public void selectAll() {
        List<Country> list = countryMapper.selectAll();
        Assert.notNull(list, "list is null");
        list.stream().forEach(c -> {
             System.err.println(c);
        });
    }

    @Test
    public void getCountryById() {
        Country countryById = countryMapper.selectByPrimaryKey(1L);
        Assert.notNull(countryById, "countryById is null");
        System.err.println(countryById);
    }

    @Test
    public void addresMapper() {
        Addres addres = addresMapper.selectByPrimaryKey(1L);
        Assert.notNull(addres, "countryById is null");
        System.err.println(addres);
    }
}
