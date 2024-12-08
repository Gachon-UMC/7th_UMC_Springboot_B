package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.repository.store.StoreRepository;
import umc.spring.validation.annotation.ExistStore;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> { // 여기서 바로 repository에 접근하면 안 됨
    // week8 미션
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
//        boolean isValid = values.stream()
//                .allMatch(value -> storeRepository.existsById(value));
//
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
//        }
//
//        return isValid;


//        // Store ID가 null이면 검증 실패
//        if (value == null) {
//            return false;
//        }
//
//        // StoreRepository를 사용해 존재 여부 검증
//        return storeRepository.existsById(value);

//        // Store ID가 null이면 검증 실패
//        if (value == null) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
//            return false;
//        }
//
//        // StoreRepository를 사용해 존재 여부 검증
//        boolean isValid = storeRepository.existsById(value);
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
//        }
//
//        return isValid; // 검증 성공


        // Store ID가 null이면 검증 실패
        if (value == null || !storeRepository.existsById(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
                    .addConstraintViolation();
            return false;
        }

        return true; // 검증 성공
    }
}