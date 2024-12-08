package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDto request){

        Mission newMission = MissionConverter.toMission(request);
        List<Mission> missionList = request.getMemberMission().stream()
                .map(mission -> {
                    return missionRepository.findById(mission).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberMission> memberMissionList = MemberMissionConverter.toMemberMissionList(missionList);

        memberMissionList.forEach(memberMission -> {
            memberMission.setMission(newMission);
        });
        return missionRepository.save(newMission);
    }
}
