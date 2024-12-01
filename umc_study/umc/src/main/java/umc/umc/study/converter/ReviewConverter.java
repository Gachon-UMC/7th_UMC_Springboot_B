package umc.umc.study.converter;

import org.springframework.data.domain.Page;
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

    public static ReviewResponseDto.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDto.ReviewPreViewDTO.builder()
                .score(review.getRating())
                .body(review.getReview())
                .build();
    }
    public static ReviewResponseDto.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDto.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDto.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .review(reviewPreViewDTOList.get(0).getReview())
                .build();
    }
}
