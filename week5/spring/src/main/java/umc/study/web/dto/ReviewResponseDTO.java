package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long id;
    private Long storeId;
    private Long userId;
    private String reviewContent;
    private String reviewImg;
    private String reviewScope;
    private LocalDateTime createdAt;
}
