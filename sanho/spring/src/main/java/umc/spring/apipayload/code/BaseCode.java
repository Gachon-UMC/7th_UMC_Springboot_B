package umc.spring.apipayload.code;

public interface BaseCode { // SuccessStatus 코드를 위한 인터페이스

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}