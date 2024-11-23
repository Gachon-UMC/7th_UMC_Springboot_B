package umc.umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc.study.apiPayload.ApiResponse;
import umc.umc.study.converter.MissionConverter;
import umc.umc.study.domain.Mission;
import umc.umc.study.service.MissionService.MissionCommandService;
import umc.umc.study.service.MissionService.MissionCommandServiceImpl;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;
import umc.umc.study.web.dto.MissionDTO.MissionResponseDto;


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
}