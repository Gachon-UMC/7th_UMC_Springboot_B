package umc.spring.service.mission;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.*;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.*;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.membermission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private List<MemberMission> memberMissionList = new ArrayList<>(); // 리스트를 필드로 유지


    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) { // week8 미션

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = memberMissionRepository.findById(request.getMemberMissionId())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.Member_Mission_NOT_FOUND));

        // 첫 번째 요청에서는 리스트를 생성, 이후에는 기존 리스트에 추가
        if (memberMissionList == null) {
            memberMissionList = new ArrayList<>();
        }
        memberMissionList.add(memberMission); // memberMission 추가


        Mission newMission = MissionConverter.toMission(request, store, memberMissionList);

        newMission.setStore(store);
        newMission.setMemberMissionList(memberMission);

        return missionRepository.save(newMission);
    }
}
