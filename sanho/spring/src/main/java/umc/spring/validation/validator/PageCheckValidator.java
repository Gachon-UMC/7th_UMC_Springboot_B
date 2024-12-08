package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;

@Component
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {
    // week9 미션

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // 여기서 페이지 번호를 -1 해주지는 못 하고 검증만 가능
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // 요청으로 온 페이지 번호가 null이거나 1 미만이면 검증 실패
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString())
                    .addConstraintViolation();
            return false;
        }

        return true; // 검증 성공
    }
}
