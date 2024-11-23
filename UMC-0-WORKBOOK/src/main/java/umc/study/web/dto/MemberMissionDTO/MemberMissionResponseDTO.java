package umc.study.web.dto.MemberMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;  // missionId?
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewListDTO{
        List<MemberMissionPreviewDTO> memberMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewDTO{
        String storeName;
        String content;
        Integer reward;
        MissionStatus missionStatus;
    }
}
