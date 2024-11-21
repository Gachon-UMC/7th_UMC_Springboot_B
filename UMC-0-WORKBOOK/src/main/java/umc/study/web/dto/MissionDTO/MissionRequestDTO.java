package umc.study.web.dto.MissionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;
import umc.study.validation.annotation.ExistMissions;
import umc.study.validation.annotation.MissionInProgress;

import java.time.LocalDateTime;
import java.util.List;

public class MissionRequestDTO {



    @Getter
    public static class JoinDto{
        @NotNull
        Integer reward;

        @NotBlank
        String content;

        @NotNull
        MissionStatus missionStatus;

        @NotNull
        LocalDateTime deadline;

        @ExistMissions
        @MissionInProgress
        List<Long> memberMission;
    }
}
