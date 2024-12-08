package umc.study.domain.enums;

import java.util.Arrays;

public enum Gender {
    Male, Female, None;

    public static Gender fromString(String value) {
        try {
            return Gender.valueOf(value);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("잘못된 형식으로 입력 : (Male, Female, None)" + value);
        }
    }
}

