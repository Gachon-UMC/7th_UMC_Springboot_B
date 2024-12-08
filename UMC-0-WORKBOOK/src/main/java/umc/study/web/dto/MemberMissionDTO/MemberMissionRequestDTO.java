package umc.study.web.dto.MemberMissionDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

public class MemberMissionRequestDTO {

    @Getter
    @Schema(name = "MemberMissionJoinRequest")
    public static class JoinDto{

        @NotNull
        Long memberId;

        @NotBlank
        String content;

        @NotNull
        Integer reward;

        @NotNull
        MissionStatus missionStatus;

    }



}
