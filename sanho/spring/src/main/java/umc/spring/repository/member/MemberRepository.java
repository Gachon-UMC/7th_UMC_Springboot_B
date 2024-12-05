package umc.spring.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> { // week8 미션

    Optional<Member> findByEmail(String email);
}