package umc.study.service.MissionService;

import umc.study.domain.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO requestDTO) {
        Store store = storeRepository.findById(requestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("가게 찾을 수 없음"));

        Mission mission = Mission.builder()
                .store(store)
                .missionDescription(requestDTO.getMissionDescription())
                .missionPoint(requestDTO.getMissionPoint())
                .deadline(requestDTO.getDeadline())
                .build();

        missionRepository.save(mission);
        return MissionConverter.toResponseDTO(mission);
    }

    public Page<MissionResponseDTO> getMissionsByStore(Long storeId, Pageable pageable) {
        Page<Mission> missions = missionRepository.findAllByStoreId(storeId, pageable);
        return missions.map(MissionConverter::toResponseDTO);
    }

    @Transactional
    public void updateMissionStatus(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("미션을 찾을 수 없습니다."));

        // 상태가 이미 INACTIVE인지 검증
        if (mission.getStatus() == Status.INACTIVE) {
            throw new IllegalStateException("이미 INACTIVE 상태인 미션입니다.");
        }

        // 상태를 INACTIVE로 변경
        mission.setStatus(Status.INACTIVE);
    }
}
