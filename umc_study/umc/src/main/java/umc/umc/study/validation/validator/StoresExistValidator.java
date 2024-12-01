package umc.umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umc.study.apiPayload.code.status.ErrorStatus;
import umc.umc.study.repository.FoodCategoryRepository;
import umc.umc.study.repository.StoreRepository;
import umc.umc.study.validation.annotation.ExistStore;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStore, Integer> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer storeId, ConstraintValidatorContext context) {
        if (storeId == null) {
            return false;  // null 값은 검증 실패 처리
        }
        return checkIStoreExists(storeId);
    }
    private boolean checkIStoreExists(Integer storeId) {
        if(storeRepository.existsById(storeId)){
            return true;
        } else {
            return false;
        }// 예시로 true 반환
    }


}
