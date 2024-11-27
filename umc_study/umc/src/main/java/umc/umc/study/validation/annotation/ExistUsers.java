package umc.umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.umc.study.validation.validator.MissionExistValidator;
import umc.umc.study.validation.validator.StoresExistValidator;
import umc.umc.study.validation.validator.UsersExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsersExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)

public @interface ExistUsers {

    String message() default "해당하는 유저가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
