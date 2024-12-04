package umc.umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import umc.umc.study.validation.validator.UserReviewExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserReviewExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUserReview {
    String message() default "해당하는 유저의 리뷰가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
