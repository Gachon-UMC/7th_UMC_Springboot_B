package umc.spring.domain.enums;

public enum Gender {
    MALE(1),
    FEMALE(2),
    NONE(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Gender fromValue(Integer value) {
        if (value == null) {
            return null; // 선택 안 했을 경우.
        }
        for (Gender gender : Gender.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 성별 : " + value);
    }
}
