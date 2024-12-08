package umc.spring.service.mission;

import umc.spring.domain.mapping.MemberMission;

public interface MissionQueryService {
    MemberMission findMemberMission(Long missionId);

    void completeMission(MemberMission memberMission);
}
