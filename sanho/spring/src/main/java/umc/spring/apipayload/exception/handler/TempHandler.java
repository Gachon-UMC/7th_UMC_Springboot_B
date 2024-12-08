package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException { // GeneralException을 상속 받음. Exception 핸들링 예시.

    public TempHandler(BaseErrorCode errorCode) { // 에러 코드 ErrorStatus ex) ErrorStatus.TEMP_EXCEPTION
        super(errorCode);
    }
}