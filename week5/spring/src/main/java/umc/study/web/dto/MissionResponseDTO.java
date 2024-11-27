package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionResponseDTO {
    private Long id;
    private String missionDescription;
    private Integer missionPoint;
    private LocalDateTime deadline;
    private Long storeId;
    private String storeName;
}
