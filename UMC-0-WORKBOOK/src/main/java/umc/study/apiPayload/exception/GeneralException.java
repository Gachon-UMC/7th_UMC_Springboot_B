package umc.study.apiPayload.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.ErrorReasonDTO;
import umc.study.apiPayload.code.status.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
