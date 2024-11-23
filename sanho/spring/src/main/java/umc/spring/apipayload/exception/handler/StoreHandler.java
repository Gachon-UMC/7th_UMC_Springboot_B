package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
