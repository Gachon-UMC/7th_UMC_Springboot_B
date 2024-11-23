package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberRepository;
import umc.study.validation.annotation.ExistMember;

import java.util.List;
@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepository memberRepository;


    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // 값이 null인 경우 유효성 검증을 실패로 처리
        if (value == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("memberId cannot be null").addConstraintViolation();
            return false;
        }

        // 회원 존재 여부 확인
        boolean isValid = memberRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
