package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.validation.annotation.CheckPage;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page <= 0) {
            return false;
        }
        return true;
    }

    public static Integer adjustPage(Integer page) {
        return page - 1;
    }
}
