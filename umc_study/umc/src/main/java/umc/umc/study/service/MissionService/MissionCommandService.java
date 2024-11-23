package umc.umc.study.service.MissionService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Mission;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;


public interface MissionCommandService {

    Mission joinMission(MissionRequestDto.@Valid JoinDto request);
}
