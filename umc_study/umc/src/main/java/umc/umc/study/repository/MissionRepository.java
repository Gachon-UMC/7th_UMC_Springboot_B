package umc.umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
}
