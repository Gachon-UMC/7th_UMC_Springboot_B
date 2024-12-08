package umc.study.web.dto.StoreDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    @Schema(name = "StoreJoinRequest")
    public static class JoinDto{

        @NotBlank
        String name;

        @NotBlank
        String address;

        Float rating;

        @NotNull
        Long regionId;
    }
}
