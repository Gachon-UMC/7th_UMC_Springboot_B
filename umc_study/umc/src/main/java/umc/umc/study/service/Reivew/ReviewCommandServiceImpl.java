package umc.umc.study.service.Reivew;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc.study.apiPayload.code.status.ErrorStatus;
import umc.umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.converter.MemberPreferConverter;
import umc.umc.study.converter.ReviewConverter;
import umc.umc.study.domain.FoodCategory;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.MemberPrefer;
import umc.umc.study.domain.Review;
import umc.umc.study.repository.FoodCategoryRepository;
import umc.umc.study.repository.MemberRepository;
import umc.umc.study.repository.ReviewRepository;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.ReviewDTO.ReviewRequestDto;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review addReview(ReviewRequestDto.JoinDto request) {

        Review newReview = ReviewConverter.toReview(request);

        return reviewRepository.save(newReview);
    }
}
