package umc.umc.study.converter;

import org.springframework.data.domain.Page;
import umc.umc.study.domain.Mission;
import umc.umc.study.domain.Review;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;
import umc.umc.study.web.dto.MissionDTO.MissionResponseDto;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;

import java.util.List;
import java.util.stream.Collectors;

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
                .cleartime(request.getCleartime())
                .title(request.getTitle())
                .id(request.getId())
                .build();
    }


    //----------------- 스토어 미션 관련 부분 ---------------------------

    public static MissionResponseDto.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDto.MissionPreViewDTO.builder()
                .titile(mission.getTitle())
                .build();
    }
    public static MissionResponseDto.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDto.MissionPreViewDTO> missionPreViewDTO = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDto.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTO.size())
                .missionList(missionPreViewDTO)
                .titile(missionPreViewDTO.get(0).getTitile())
                .build();
    }


}
