package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}
