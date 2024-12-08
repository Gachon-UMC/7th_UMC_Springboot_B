package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.JoinDto request);
}
