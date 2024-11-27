package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.ReviewScope;
import umc.study.validation.annotation.ExistStores;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotNull
    @ExistStores
    private Long storeId;

    @NotNull
    private Long userId;

    @NotBlank
    @Size(max = 500, message = "최대 500자까지 입력 가능합니다.")
    private String reviewContent;

    @NotNull(message = "별점 후기가 필요합니다.")
    private ReviewScope reviewScope;

    private String reviewImg; // 선택
}
