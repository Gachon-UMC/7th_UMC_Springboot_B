package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

//    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
    @Query(
            value = "SELECT mm FROM MemberMission mm JOIN FETCH mm.mission WHERE mm.member = :member",
            countQuery = "SELECT count(mm) FROM MemberMission mm WHERE mm.member = :member"
    )
    Page<MemberMission> findAllByMember(@Param("member") Member member, Pageable pageable);
}