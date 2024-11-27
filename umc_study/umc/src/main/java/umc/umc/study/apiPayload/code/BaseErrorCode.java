package umc.umc.study.apiPayload.code;

import umc.umc.study.apiPayload.code.status.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
