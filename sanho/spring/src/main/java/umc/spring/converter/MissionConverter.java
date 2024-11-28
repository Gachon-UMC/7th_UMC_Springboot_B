package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MissionConverter { // week8 미션

    public static MissionResponseDTO.AddMissionResultDTO toAddMissionDTO(Mission mission){
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionDTO request, Store store, List<MemberMission> memberMissionList) {

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .memberMissionList(memberMissionList)
                .build();
    }

    // week9 미션 - 진행 중인 미션을 진행 완료로 수정하기
    public static MissionResponseDTO.MemberMissionDTO memberMissionDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();

        return MissionResponseDTO.MemberMissionDTO.builder()
                .memberName(memberMission.getMember().getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .status(memberMission.getStatus())
                .build();
    }

}
