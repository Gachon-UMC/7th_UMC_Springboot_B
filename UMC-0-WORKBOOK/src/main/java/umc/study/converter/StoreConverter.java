package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO.StoreRequestDTO;
import umc.study.web.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request){


        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission){
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .content(mission.getContent())
                .reward(mission.getReward())
                .missionStatus(mission.getMissionStatus())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList){

        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::missionPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}
