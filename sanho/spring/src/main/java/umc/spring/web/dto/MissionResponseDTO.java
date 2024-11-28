package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO { // week8 미션

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO{
        Long missionId;
        LocalDateTime createdAt;
    }

    // week9 미션 - 진행 중인 미션 진행 완료로 바꾸기
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionDTO {
        String memberName;
        String missionSpec;
        Integer reward;
        MissionStatus status;
    }

}
