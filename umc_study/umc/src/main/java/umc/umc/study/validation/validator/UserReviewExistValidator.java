package umc.umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umc.study.apiPayload.code.status.ErrorStatus;
import umc.umc.study.repository.FoodCategoryRepository;

import umc.umc.study.repository.UsersRepository;

import umc.umc.study.validation.annotation.ExistUserReview;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserReviewExistValidator implements ConstraintValidator<ExistUserReview, Integer> {
    private final UsersRepository usersRepository;

    @Override
    public void initialize(ExistUserReview constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer userId, ConstraintValidatorContext context) {
        if (userId == null) {
            return false;  // null 값은 검증 실패 처리
        }
        return checkIfUserReviewExists(userId);
    }
    private boolean checkIfUserReviewExists(Integer userId) {
        if(usersRepository.existsById(userId)){
            return true;
        } else {
            return false;
        }// 예시로 true 반환
    }
}
