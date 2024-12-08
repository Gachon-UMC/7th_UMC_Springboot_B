package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.validator.CheckPageValidator;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<ReviewResponseDTO> addReviewToStore(@RequestBody @Valid ReviewRequestDTO reviewRequestDTO) {
        ReviewResponseDTO response = reviewService.addReviewToStore(reviewRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 9주차 워크북 : 내가 작성한 리뷰 목록 API
    @Operation(summary = "내가 작성한 리뷰 목록 보기", description = "사용자가 작성한 리뷰 목록을 페이지네이션으로 조회")
    @GetMapping("/reviews/my")
    public Page<ReviewResponseDTO> getMyReviews(
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @CheckPage @RequestParam(name = "page") Integer page) {

        // 페이지 번호 조정
        Integer adjustedPage = CheckPageValidator.adjustPage(page);
        Pageable pageable = PageRequest.of(adjustedPage, 10);

        return reviewService.getMyReviews(pageable);
    }

}
