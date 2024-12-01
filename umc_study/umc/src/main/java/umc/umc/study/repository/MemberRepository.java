package umc.umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
