package umc.umc.study.web.dto.MissionDTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MissionRequestDto {
    @Getter
    public static class JoinDto{
        @NotNull
        Integer clear;
        @NotNull
        Integer store_id;
        @NotNull
        Integer id;

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime cleartime;
        @NotNull
        String title;

    }
}
