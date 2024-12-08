package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.validation.annotation.MissionPossible;

@RequiredArgsConstructor
public class MissionPossibleValidator implements ConstraintValidator<MissionPossible, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 유저 ID는 고정값(1) 기준으로 확인
        Long userId = 1L;

        // 이미 도전 중인 미션인지 확인
        return !userMissionRepository.existsByUserIdAndMissionId(userId, missionId);
    }
}