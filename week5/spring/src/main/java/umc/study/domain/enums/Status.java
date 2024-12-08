package umc.study.domain.enums;

public enum Status {
    ACTIVE, INACTIVE;

    public static Status fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Status는 절대 비거나 NULL이면 앙댐");
        }
        try {
            return Status.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("잘못된 형식으로 입력 : " + value + ". (ACTIVE, INACTIVE)");
        }
    }
}
