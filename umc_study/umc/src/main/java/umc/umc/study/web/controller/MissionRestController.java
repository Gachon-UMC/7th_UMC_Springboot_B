package umc.umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc.study.apiPayload.ApiResponse;
import umc.umc.study.converter.MissionConverter;
import umc.umc.study.converter.ReviewConverter;
import umc.umc.study.domain.Mission;
import umc.umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.umc.study.service.MissionService.MissionQueryServiceImpl;
import umc.umc.study.service.StoreService.StoreQueryServiceImpl;
import umc.umc.study.validation.annotation.CheckPage;
import umc.umc.study.validation.annotation.ExistMission;
import umc.umc.study.validation.annotation.ExistStore;
import umc.umc.study.validation.annotation.ExistUsers;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;
import umc.umc.study.web.dto.MissionDTO.MissionResponseDto;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;


@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandServiceImpl missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDto.JoinResultDTO> joinMission(@RequestBody @Valid MissionRequestDto.JoinDto request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }


    private final MissionQueryServiceImpl missionQueryServiceImpl;




    @GetMapping("/{storeId}/missions/stores")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDto.MissionPreViewListDTO> getStoreMissionList(
            @ExistStore @PathVariable(name = "storeId") Integer storeId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @CheckPage @RequestParam(name = "page") Integer page
    ){
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionQueryServiceImpl.getStoreMissionList(storeId,page-1)));
    }



    @GetMapping("/{userId}/missions/users")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDto.MissionPreViewListDTO> getUserMissionList(
            @ExistUsers @PathVariable(name = "userId") Integer userId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @CheckPage @RequestParam(name = "page") Integer page
    ){
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionQueryServiceImpl.getUserMissionList(userId,page-1)));
    }

}