package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@CrossOrigin(origins = "http://localhost:8080") // 필요한 프론트엔드 URL 설정
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.JoinDto request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
