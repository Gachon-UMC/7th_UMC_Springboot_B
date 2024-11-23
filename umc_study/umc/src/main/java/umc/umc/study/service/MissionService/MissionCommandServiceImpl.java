package umc.umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc.study.apiPayload.code.status.ErrorStatus;
import umc.umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.converter.MemberPreferConverter;
import umc.umc.study.converter.MissionConverter;
import umc.umc.study.domain.FoodCategory;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.MemberPrefer;
import umc.umc.study.domain.Mission;
import umc.umc.study.repository.FoodCategoryRepository;
import umc.umc.study.repository.MemberRepository;
import umc.umc.study.repository.MissionRepository;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MissionDTO.MissionRequestDto;

import java.util.List;
import java.util.stream.Collectors;

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
