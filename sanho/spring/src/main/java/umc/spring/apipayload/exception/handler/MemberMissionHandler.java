package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode code) {
        super(code);
    }
}
