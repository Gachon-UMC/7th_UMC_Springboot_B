package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO { // week8 미션

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddStoreDTO {
        Long storeId;
        LocalDateTime createdAt;
    }

    // 여기부터 week9 코드 - 리뷰 목록 조회 응답 DTO
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
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
    public static class ReviewPreViewDTO {
        String ownerNickname; // 닉네임 말고도 사용자의 정보 더 적을 게 있다면 여기도 DTO로 빼는 게 낫다.
        // MemberInfoDTO memberInfo; - 사용자의 정보가 담긴 DTO
        Float score;
        String body;
        LocalDate createdAt;
    }

}
