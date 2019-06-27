package mybatis.example.domain.person;

import lombok.*;

import java.util.Arrays;

/**
 * @author: zscome
 * DateTime: 2019-06-11 12:00
 */
public enum AuthEnum implements EnumType {
    admin("admin", 0), guest("guest", 1), unknown("unknown", 2);

    AuthEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private int value;


    public EnumType valueOfType(int value) {
        return Arrays.stream(values()).filter(type -> type.getValue() == value).findFirst().orElse(unknown);
    }
}
