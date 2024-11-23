package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;


public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDto {

        @NotBlank
        String title;

        @NotNull
        String body;

        @NotNull
        Float score;

        @ExistMember
        Long memberId;

        @ExistStore
        Long storeId;
    }

}
