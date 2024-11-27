package umc.umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc.study.apiPayload.ApiResponse;

import umc.umc.study.converter.ReviewConverter;

import umc.umc.study.domain.Review;


import umc.umc.study.service.Reivew.ReviewCommandService;


import umc.umc.study.web.dto.ReviewDTO.ReviewRequestDto;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;



@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDto.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDto.JoinDto request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
