package umc.umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc.study.converter.MissionConverter;
import umc.umc.study.domain.Mission;
import umc.umc.study.repository.FoodCategoryRepository;
import umc.umc.study.repository.MissionRepository;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl {
    private final MissionRepository missionRepository;

    private final FoodCategoryRepository foodCategoryRepository;


    @Transactional
    public Mission joinMission(MissionRequestDto.JoinDto request) {

        Mission newMission = MissionConverter.toMission(request);
        newMission.setMissionStatus(0,"1000원 이상 쓰기",1);

        return missionRepository.save(newMission);
    }
}
