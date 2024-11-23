package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class MissionHandler extends GeneralException { // week8 미션

    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
