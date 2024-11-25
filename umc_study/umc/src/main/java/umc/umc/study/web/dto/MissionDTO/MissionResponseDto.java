package umc.umc.study.web.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.umc.study.validation.annotation.ExistMission;

import java.time.LocalDateTime;

public class MissionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        @ExistMission
        Integer missionId;
        String title;
        Integer clear;
    }
}
