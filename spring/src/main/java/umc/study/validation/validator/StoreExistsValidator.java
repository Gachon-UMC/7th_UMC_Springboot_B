package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ExistStores;

@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ExistStores, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null || storeId < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Store ID는 1 이상의 값이어야 합니다.")
                    .addConstraintViolation();
            return false;
        }
        if (!storeRepository.existsById(storeId)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("존재하지 않는 가게입니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }


}
