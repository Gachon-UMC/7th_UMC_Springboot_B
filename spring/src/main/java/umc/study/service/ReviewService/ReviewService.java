package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReviewResponseDTO addReviewToStore(Long storeId, ReviewRequestDTO request) {
        // storeId는 DTO에서 검증되므로 다시 확인할 필요 없음
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("ID와 함께 가게를 찾지 못함 : " + storeId));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("ID와 함께 유저를 찾지 못함 : " + request.getUserId()));

        Review review = ReviewConverter.toEntity(request, user, store);
        store.addReview(review); // 양방향 관계 설정
        reviewRepository.save(review);

        // Store의 리뷰 평균 스코프 업데이트
        store.updateStoreScope();

        return ReviewConverter.toResponseDTO(review);
    }

    public Page<ReviewResponseDTO> getMyReviews(Pageable pageable) {
        return reviewRepository.findAllByUserId(1L, pageable) // 동동(user_id=1) 기준
                .map(ReviewConverter::toResponseDTO);
    }
}
