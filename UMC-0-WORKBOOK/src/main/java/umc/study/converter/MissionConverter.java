package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission){
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId((mission.getId()))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinDto request){

        MissionStatus missionStatus = null;

        switch(request.getMissionStatus()){
            case CHALLENGING:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case COMPLETED:
                missionStatus = MissionStatus.COMPLETED;
                break;
        }

        return Mission.builder()
                .reward(request.getReward())
                .content(request.getContent())
                .missionStatus(missionStatus)
                .deadline(request.getDeadline())
                .build();
    }
}
