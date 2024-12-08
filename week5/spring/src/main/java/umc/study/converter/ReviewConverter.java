package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO request, User user, Store store) {
        return Review.builder()
                .user(user)
                .store(store)
                .reviewContent(request.getReviewContent())
                .reviewImg(request.getReviewImg())
                .reviewScope(request.getReviewScope())
                .build();
    }

    public static ReviewResponseDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .storeId(review.getStore().getId())
                .userId(review.getUser().getId())
                .reviewContent(review.getReviewContent())
                .reviewImg(review.getReviewImg())
                .reviewScope(review.getReviewScope().name())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
