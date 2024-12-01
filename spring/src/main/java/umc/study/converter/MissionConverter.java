package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

@Component
public class MissionConverter {

    public static Mission toEntity(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .store(store)
                .missionDescription(requestDTO.getMissionDescription())
                .missionPoint(requestDTO.getMissionPoint())
                .deadline(requestDTO.getDeadline())
                .build();
    }

    public static MissionResponseDTO toResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .storeId(mission.getStore().getId())
//                .storeName(mission.getStore().getStoreName())
                .missionDescription(mission.getMissionDescription())
                .missionPoint(mission.getMissionPoint())
                .deadline(mission.getDeadline())
                .status(mission.getStatus().name())
                .createdAt(mission.getCreatedAt())
                .updatedAt(mission.getUpdatedAt())
                .build();
    }
}