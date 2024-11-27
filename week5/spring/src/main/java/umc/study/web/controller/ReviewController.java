package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewService;
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

}
