package umc.umc.study.converter;

import umc.umc.study.domain.Gender;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Mission;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;
import umc.umc.study.web.dto.MissionDTO.MissionResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {
    public static MissionResponseDto.JoinResultDTO toJoinResultDTO(Mission mission){
        return MissionResponseDto.JoinResultDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .clear(mission.getClear())
                .build();
    }

    public static Mission toMission(MissionRequestDto.JoinDto request){
        return Mission.builder()
                .clear(request.getClear())
                .store_id(request.getStore_id())
                .cleartime(request.getCleartime())
                .title(request.getTitle())
                .id(request.getId())
                .build();
    }
}
