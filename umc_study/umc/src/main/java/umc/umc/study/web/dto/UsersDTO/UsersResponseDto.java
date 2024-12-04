package umc.umc.study.web.dto.UsersDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UsersResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Integer missionId;
        Integer missionStatus;
        //String missionTitle;
        Integer userId;
    }
}
