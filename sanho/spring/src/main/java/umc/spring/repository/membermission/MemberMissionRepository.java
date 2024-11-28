package umc.spring.repository.membermission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> { // week8 미션

    // week9 미션 - 내가 진행 중인 미션 목록
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);

    // week9 미션 - 진행 중인 미션을 진행 완료로 수정하기
    MemberMission findByMission(Mission mission);
}
