package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.ReviewRepository;
import umc.study.validation.annotation.ExistReviews;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewExistValidator implements ConstraintValidator<ExistReviews, List<Long>> {

    private final ReviewRepository reviewRepository;


    @Override
    public void initialize(ExistReviews constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        // 값이 null인 경우 유효성 검증을 실패로 처리
        if (value == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Store ID cannot be null").addConstraintViolation();
            return false;
        }

        // 리스트의 모든 ID가 유효한지 확인
        for (Long reviewId : value) {
            if (!reviewRepository.existsById(reviewId)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_NOT_FOUND.toString()).addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}
