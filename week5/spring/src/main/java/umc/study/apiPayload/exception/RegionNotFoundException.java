package umc.study.apiPayload.exception;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;
import umc.study.apiPayload.code.status.ErrorStatus;

public class RegionNotFoundException extends GeneralException {

    public RegionNotFoundException() {
        super(
                (BaseErrorCode) ErrorReasonDTO.builder()
                        .httpStatus(ErrorStatus._BAD_REQUEST.getHttpStatus())
                        .isSuccess(false)
                        .code(ErrorStatus._BAD_REQUEST.getCode())
                        .message("Region not found.")
                        .build()
        );
    }
}
