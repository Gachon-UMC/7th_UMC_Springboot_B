package umc.umc.study.service.Reivew;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Review;

import umc.umc.study.web.dto.ReviewDTO.ReviewRequestDto;

@Service
public interface ReviewCommandService {

    Review addReview(ReviewRequestDto.@Valid JoinDto request);
}
