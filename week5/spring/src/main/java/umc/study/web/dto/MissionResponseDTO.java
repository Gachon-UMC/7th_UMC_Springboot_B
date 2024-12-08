package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionResponseDTO {
    private Long id;
    private Long storeId;
//    private String storeName;
    private String missionDescription;
    private Integer missionPoint;
    private LocalDateTime deadline;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
