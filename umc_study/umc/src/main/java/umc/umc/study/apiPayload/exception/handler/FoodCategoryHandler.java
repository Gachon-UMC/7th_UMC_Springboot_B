package umc.umc.study.apiPayload.exception.handler;

import umc.umc.study.apiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends RuntimeException {
    public FoodCategoryHandler(ErrorStatus FOOD_CATEGORY_NOT_FOUND) {
        super(String.valueOf(FOOD_CATEGORY_NOT_FOUND));


    }
}
