package mybatis.example.domain.person;

/**
 * @author: zscome
 * DateTime: 2019-06-11 11:47
 */
public interface EnumType {
    int getValue();

    String getName();

    EnumType valueOfType(int value);


}
