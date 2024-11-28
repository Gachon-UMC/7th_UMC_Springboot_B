package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.MemberMissionHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.membermission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission findMemberMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId).get();
        MemberMission memberMission = memberMissionRepository.findByMission(mission);

        return memberMission;
    }

    @Override
    @Transactional
    public void completeMission(MemberMission memberMission) {
        // 미션 상태가 COMPLETE면 예외 터뜨리기
        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new MemberMissionHandler(ErrorStatus.MISSION_ALREADY_COMPLETE);
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
    }
}
