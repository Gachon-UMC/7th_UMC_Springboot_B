package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.mission.MissionCommandService;
import umc.spring.service.mission.MissionQueryService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missons")
@Validated
public class MissionRestController { // week8 미션

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> add(@RequestBody @Valid MissionRequestDTO.AddMissionDTO request){

        Mission mission = missionCommandService.addMission(request);

        return ApiResponse.onSuccess((MissionConverter.toAddMissionDTO(mission)));
    }

    @PatchMapping("/{missionId}/status")
    @Operation(summary = "진행 중인 미션을 진행 완료로 수정하는 API", description = "진행 중인 미션을 진행 완료로 수정하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "진행 완료로 수정할 미션의 아이디, path variable 입니다!"),
    })
    public ApiResponse<MissionResponseDTO.MemberMissionDTO> completeMission(@ExistMission @PathVariable Long missionId) {
        MemberMission memberMission = missionQueryService.findMemberMission(missionId);
        missionQueryService.completeMission(memberMission);
        return ApiResponse.onSuccess(MissionConverter.memberMissionDTO(memberMission));
    }
}
