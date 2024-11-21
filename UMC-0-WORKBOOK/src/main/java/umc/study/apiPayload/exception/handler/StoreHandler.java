package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler (BaseErrorCode errorCode){
        super(errorCode);
    }
}
