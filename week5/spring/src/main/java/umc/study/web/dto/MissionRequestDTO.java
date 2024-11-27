package umc.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.validation.annotation.ExistStores;
import umc.study.validation.annotation.ExistStores;

import java.time.LocalDateTime;

@Getter
@Setter
public class MissionRequestDTO {

    @NotNull
    @ExistStores
    private Long storeId;

    @NotBlank
    private String missionDescription;

    @NotNull
    @Min(value = 1, message = "미션 포인트 보상은 반드시 0포인트 이상이어야 합니다.")
    private Integer missionPoint;

    @NotNull
    @Future(message = "Deadline은 반드시 미래의 시간대여야 합니다.")
    private LocalDateTime deadline;
}
