package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException { // week8 미션
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
