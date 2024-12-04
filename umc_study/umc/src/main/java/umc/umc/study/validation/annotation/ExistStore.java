package umc.umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import umc.umc.study.validation.validator.StoresExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoresExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {

    String message() default "해당하는 음식점이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
