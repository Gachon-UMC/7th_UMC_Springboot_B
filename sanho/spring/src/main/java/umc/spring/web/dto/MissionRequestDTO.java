package umc.spring.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMemberMission;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO {

        @NotNull
        Integer reward;

        @NotEmpty
        LocalDate deadline;

        @NotEmpty
        String missionSpec;

        @NotEmpty
        Long storeId;

        @ExistMemberMission
        Long memberMissionId;

    }
}
