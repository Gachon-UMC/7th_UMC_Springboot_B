package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.Mission;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
