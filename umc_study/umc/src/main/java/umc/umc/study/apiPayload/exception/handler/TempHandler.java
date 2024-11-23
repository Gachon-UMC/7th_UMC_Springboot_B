package umc.umc.study.apiPayload.exception.handler;

import umc.umc.study.apiPayload.code.BaseErrorCode;
import umc.umc.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
