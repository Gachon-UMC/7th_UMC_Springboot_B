package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.UserMissionService.UserMissionService;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequestMapping("/missions/challenges")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @PostMapping
    public ResponseEntity<UserMissionResponseDTO> challengeMission(
            @RequestBody @Valid UserMissionRequestDTO requestDTO) {
        UserMissionResponseDTO responseDTO = userMissionService.possibleMission(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
