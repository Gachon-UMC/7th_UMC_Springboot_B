package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static List<MemberMission> toMemberMissionList(List<Mission> missionList){

        return missionList.stream()
                .map(mission ->
                        MemberMission.builder()
                                .mission(mission)
                                .build()
                ).collect(Collectors.toList());
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO(MemberMission memberMission){
        Mission mission = memberMission.getMission();

        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .content(mission.getContent())
                .reward(mission.getReward())
                .missionStatus(mission.getMissionStatus())
                .build();
    }


    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO(Page<MemberMission> memberMissionList){
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreviewDTOList.size())
                .memberMissionList(memberMissionPreviewDTOList)
                .build();
    }

}
