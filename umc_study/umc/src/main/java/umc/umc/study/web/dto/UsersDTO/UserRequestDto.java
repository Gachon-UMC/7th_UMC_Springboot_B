package umc.umc.study.web.dto.UsersDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public class UserRequestDto {
    @Getter
    public static class JoinDto{
        @NotNull
        Integer id;

        @NotNull
        Integer mission_id;

    }
}
