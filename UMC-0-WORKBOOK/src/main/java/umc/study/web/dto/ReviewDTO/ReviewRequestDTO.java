package umc.study.web.dto.ReviewDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;

public class ReviewRequestDTO {

    @Getter
    @Schema(name = "ReviewJoinRequest")
    public static class JoinDto{
        @NotBlank
        String content;

        @NotNull
        Float rating;

        @ExistStores
        Long storeId;


    }
}
