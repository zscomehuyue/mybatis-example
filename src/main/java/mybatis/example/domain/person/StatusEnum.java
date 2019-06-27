package mybatis.example.domain.person;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: zscome
 * DateTime: 2019-05-20 11:24
 */
public enum StatusEnum implements EnumType {
    invalid("无效用户", 0), valid("有效用户", 1), unknown("value is order", 2);

    StatusEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private int value;

    public boolean isValide() {
        return this == valid;
    }

    public boolean isInvalide() {
        return this == valid;
    }

    public boolean toValid() {
        return this.getValue() == 1 ? true : false;
    }


    @Override
    public EnumType valueOfType(int value) {
        return Arrays.stream(values()).filter(type -> type.getValue() == value).findFirst().orElse(unknown);
    }

}
