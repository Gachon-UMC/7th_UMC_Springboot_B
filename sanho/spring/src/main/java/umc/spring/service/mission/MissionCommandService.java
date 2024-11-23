package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService { // week8 미션

    Mission addMission(MissionRequestDTO.AddMissionDTO request);
}
