package umc.study.validation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.MissionInProgress;

import java.util.List;
@Component
@RequiredArgsConstructor
public class MissionInProgressValidator implements ConstraintValidator<MissionInProgress, List<Long>> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(MissionInProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> missionRepository.existsById(value));

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_COMPLETED.toString()).addConstraintViolation();
        }

        return isValid;
    }

//    @Override
//    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
//        boolean isValid = values.stream()
//                .allMatch(value -> missionRepository.existsById(value));
//
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
//        }
//
//        return isValid;
//    }
}
