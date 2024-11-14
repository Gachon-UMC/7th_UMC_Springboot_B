package umc.spring.apipayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code; // 이 code를 SuccessStatus가 구현하고, SuccessStatus에서 데이터를 가져온다.

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){ // ErrorStatus에서 ErrorReasonDTO 형식으로 받아와서 ExceptionAdvice로 넘김
        return this.code.getReasonHttpStatus();
    }
}