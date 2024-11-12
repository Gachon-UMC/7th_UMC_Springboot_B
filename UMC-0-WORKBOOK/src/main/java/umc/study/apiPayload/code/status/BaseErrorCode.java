package umc.study.apiPayload.code.status;

import umc.study.apiPayload.code.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
