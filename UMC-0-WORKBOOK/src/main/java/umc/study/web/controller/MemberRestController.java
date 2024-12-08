package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMissions;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.study.web.dto.MemberDTO.MemberResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:8080") // 필요한 프론트엔드 URL 설정
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    private final MemberQueryService memberQueryService;

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 회원의 리뷰 목록 조회 API", description = "특정 회원의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.MyReviewPreviewListDTO> getMyReviewList(Long memberId, Integer page) {
        Page<Review> reviews = memberQueryService.getMyReviewList(memberId, page - 1);
        List<MemberResponseDTO.MyReviewPreviewDTO> reviewDTOs = reviews.stream()
                .map(review -> new MemberResponseDTO.MyReviewPreviewDTO(
                        review.getMember().getName(), review.getRating(), review.getContent(), review.getCreatedAt().toLocalDate()))
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(new MemberResponseDTO.MyReviewPreviewListDTO(
                reviewDTOs, reviews.getSize(), reviews.getTotalPages(), reviews.getTotalElements(),
                reviews.isFirst(), reviews.isLast()));
    }
//     public ApiResponse<MemberResponseDTO.MyReviewPreviewListDTO> getMyReviewList(
//            @ExistMember @PathVariable(name = "memberId") Long memberId,
//            @CheckPage @RequestParam(name = "page") Integer page
//    ){
//        int zeroBasedPage = page - 1;  // page1을 0으로 만들어 return
//
//        Page<Review> myReviewList = memberQueryService.getMyReviewList(memberId, zeroBasedPage);
//        return ApiResponse.onSuccess(MemberConverter.myReviewPreviewListDTO(myReviewList));
//    }

}