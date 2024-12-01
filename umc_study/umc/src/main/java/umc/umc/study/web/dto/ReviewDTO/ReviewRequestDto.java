package umc.umc.study.web.dto.ReviewDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class ReviewRequestDto {



    @Getter
    public static class JoinDto{
        Integer id;
        @NotNull(message = "평점은 필수 입력값입니다.")
        @Min(value = 1, message = "평점은 최소 1점 이상이어야 합니다.")
        @Max(value = 5, message = "평점은 최대 5점 이하이어야 합니다.")
        Integer rating;
        String review;
        Integer re_store_id;
        Integer re_user_id;
    }
}