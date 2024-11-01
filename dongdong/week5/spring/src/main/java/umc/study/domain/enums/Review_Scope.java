package umc.study.domain.enums;

public enum Review_Scope {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    Review_Scope(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
