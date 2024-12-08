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
        return storeId != null && storeRepository.existsById(storeId);
    }
}
