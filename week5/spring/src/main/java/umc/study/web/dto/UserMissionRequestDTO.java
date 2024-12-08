package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.MissionPossible;

@Getter
public class UserMissionRequestDTO {

    @NotNull(message = "도전할 미션 ID는 필수입니다.")
    @MissionPossible
    private Long missionId;
}
