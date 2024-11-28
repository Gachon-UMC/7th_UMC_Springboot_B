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
import umc.study.service.UserMissionService.UserMissionService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.validator.CheckPageValidator;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequestMapping("/missions/challenges")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @Operation(summary = "User 동동의 미션 목록에 미션 추가")
    @PostMapping
    public ResponseEntity<UserMissionResponseDTO> challengeMission(
            @RequestBody @Valid UserMissionRequestDTO requestDTO) {
        UserMissionResponseDTO responseDTO = userMissionService.possibleMission(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "내가 진행 중인 미션 조회", description = "진행 중인 미션을 페이지 단위로 조회")
    @GetMapping("/my-missions")
    public Page<MissionResponseDTO> getMyMissions(
            @Parameter(description = "User ID (기본값: 1)", example = "1")
            @RequestParam(defaultValue = "1") Long userId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        // 페이지 번호 조정
        Integer adjustedPage = CheckPageValidator.adjustPage(page);
        Pageable pageable = PageRequest.of(adjustedPage, 10);

        return userMissionService.getMissionsByUser(userId, pageable);
    }
}
