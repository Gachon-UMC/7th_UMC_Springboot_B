package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
