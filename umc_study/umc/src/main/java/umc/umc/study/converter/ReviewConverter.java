package umc.umc.study.converter;

import umc.umc.study.domain.*;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.umc.study.web.dto.ReviewDTO.ReviewRequestDto;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDto.JoinResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDto.JoinResultDTO.builder()
                .Id(review.getId())
                .review(review.getReview())
                .build();
    }

    public static Review toReview(ReviewRequestDto.JoinDto request){
        return Review.builder()
                .id(request.getId())
                .review(request.getReview())
                .rating(request.getRating())
                .build();

    }
}
