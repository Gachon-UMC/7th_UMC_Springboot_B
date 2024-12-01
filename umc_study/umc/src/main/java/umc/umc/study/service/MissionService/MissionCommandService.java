package umc.umc.study.service.MissionService;

import jakarta.validation.Valid;
import umc.umc.study.domain.Mission;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;


public interface MissionCommandService {

    Mission joinMission(MissionRequestDto.@Valid JoinDto request);
}
