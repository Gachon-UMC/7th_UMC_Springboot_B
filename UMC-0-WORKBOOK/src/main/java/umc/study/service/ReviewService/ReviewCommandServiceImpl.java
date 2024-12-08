package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements  ReviewCommandService{

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDto request){

        // 가게 조회
        Store store = storeRepository.findById(Long.valueOf(request.getStoreId()))
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        // Review 엔티티 변환
        Review newReview = ReviewConverter.toReview(request);

        // 지역-가게 관계 설정
        store.getReviewList().add(newReview);
//        newStore.setRegion(region);

        // 저장
        return reviewRepository.save(newReview);

    }
}
