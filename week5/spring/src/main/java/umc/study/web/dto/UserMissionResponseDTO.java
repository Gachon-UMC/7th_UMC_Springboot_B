package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMissionResponseDTO {
    private Long id;
    private Long userId;
    private Long missionId;
}
