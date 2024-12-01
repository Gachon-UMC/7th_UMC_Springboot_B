package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class RegionExistsValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(Long regionId, ConstraintValidatorContext context) {
        if (regionId == null || regionId < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Region ID는 1 이상의 값이어야 합니다.")
                    .addConstraintViolation();
            return false;
        }
        if (!regionRepository.existsById(regionId)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("존재하지 않는 Region ID입니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
