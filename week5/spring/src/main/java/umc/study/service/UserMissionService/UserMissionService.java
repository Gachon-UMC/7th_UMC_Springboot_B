package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.UserMission;
import umc.study.domain.enums.Status;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    private final MissionConverter missionConverter;


    @Transactional
    public UserMissionResponseDTO possibleMission(UserMissionRequestDTO requestDTO) {
        // 유저와 미션 엔티티 조회
        User user = userRepository.findById(1L) // 동동의 고정 userId
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Mission mission = missionRepository.findById(requestDTO.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("미션을 찾을 수 없습니다."));

        // UserMission 엔티티 생성 및 저장
        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .build();

        userMissionRepository.save(userMission);

        return new UserMissionResponseDTO(userMission.getId(), user.getId(), mission.getId());
    }

    @Transactional(readOnly = true)
    public Page<MissionResponseDTO> getMissionsByUser(Long userId, Pageable pageable) {
        Page<UserMission> userMissions = userMissionRepository.findAllByUserId(userId, pageable);
        return userMissions.map(userMission ->
                MissionConverter.toResponseDTO(userMission.getMission()));
    }

    @Transactional
    public Page<MissionResponseDTO> completeMissionsByUser(Long userId, Pageable pageable) {
        Page<UserMission> userMissions = userMissionRepository.findByUserIdAndMissionStatus(userId, Status.ACTIVE, pageable);
        userMissions.forEach(userMission -> userMission.getMission().setStatus(Status.INACTIVE));

        return userMissions.map(userMission -> missionConverter.toResponseDTO(userMission.getMission()));
    }
}
