package umc.umc.study.web.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.umc.study.validation.annotation.ExistMission;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        @ExistMission
        Integer missionId;
        String title;
        Integer clear;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        String titile;
        List<MissionResponseDto.MissionPreViewDTO> missionList;
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
    public static class MissionPreViewDTO {
        String titile;
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
        Integer UserId;

    }
}
