package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<ApiResponse<MissionResponseDTO>> addMission(
            @Valid @RequestBody MissionRequestDTO requestDTO) {
        MissionResponseDTO responseDTO = missionService.addMission(requestDTO);
        return ResponseEntity.ok(ApiResponse.onSuccess(responseDTO));
    }
}
