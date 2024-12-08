package umc.study.domain.enums;

import java.util.Arrays;

public enum ReviewScope {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    ReviewScope(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 정수 값을 기반으로 ReviewScope를 반환하는 메서드
    public static ReviewScope fromValue(int value) {
        return Arrays.stream(values())
                .filter(scope -> scope.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 형식으로 입력 : (1, 2, 3, 4, 5)" + value));
    }
}
