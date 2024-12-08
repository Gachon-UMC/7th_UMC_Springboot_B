package umc.spring.web.controller;

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
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.store.StoreCommandService;
import umc.spring.service.store.StoreQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Validated
public class StoreRestController { // week8 미션

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService; // week9 코드

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddStoreDTO> add(@RequestBody @Valid StoreRequestDTO.AddStoreDto request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess((StoreConverter.toAddResultDTO(store)));

    }

    // week9 실습 코드
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
//        storeQueryService.getReviewList(storeId, page);
//        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));

        // 서비스에서 리뷰 목록 가져오기
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId, page - 1);

        // DTO 변환: 리뷰 목록과 페이징 정보
        StoreResponseDTO.ReviewPreViewListDTO reviewListDTO = StoreConverter.reviewPreViewListDTO(reviewPage);

        // 성공 응답 반환
        return ApiResponse.onSuccess(reviewListDTO);
    }

    // week9 미션 - 특정 가게 미션 목록 조회
    @GetMapping("/{storeId}/misisons")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, query string 입니다. 1 이상의 페이지 번호를 보내주세요!")
    })
    public ApiResponse<StoreResponseDTO.StoreMissionListDTO> getMissionList(@ExistStore @PathVariable Long storeId, @CheckPage @RequestParam Integer page) {

        // 서비스에서 미션 목록 가져오기
        Page<Mission> missionPage = storeQueryService.getMissionList(storeId, page - 1);

        // 성공 응답 반환
        return ApiResponse.onSuccess(StoreConverter.storeMissionListDTO(missionPage));
    }
}