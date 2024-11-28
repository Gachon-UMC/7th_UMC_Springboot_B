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
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionService;
import umc.study.service.UserMissionService.UserMissionService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.validator.CheckPageValidator;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final UserMissionService userMissionService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<MissionResponseDTO>> addMission(
            @Valid @RequestBody MissionRequestDTO requestDTO) {
        MissionResponseDTO responseDTO = missionService.addMission(requestDTO);
        return ResponseEntity.ok(ApiResponse.onSuccess(responseDTO));
    }

    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게(Store)의 미션(Mission) 목록을 페이지네이션으로 조회")
    @GetMapping("/missions/store")
    public Page<MissionResponseDTO> getMissionsByStore(
            @Parameter(description = "가게 ID", example = "1")
            @RequestParam(name = "storeId") Long storeId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @CheckPage @RequestParam(name = "page") Integer page) {

        Integer adjustedPage = CheckPageValidator.adjustPage(page);
        Pageable pageable = PageRequest.of(adjustedPage, 10);

        return missionService.getMissionsByStore(storeId, pageable);
    }

    @PatchMapping("/missions/{missionId}/status")
    @Operation(summary = "미션 상태 변경", description = "특정 미션의 상태를 INACTIVE로 변경")
    public ResponseEntity<String> updateMissionStatus(
            @PathVariable Long missionId) {
        missionService.updateMissionStatus(missionId);
        return ResponseEntity.ok("Mission status updated to INACTIVE");
    }

}
