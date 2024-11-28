package umc.spring.repository.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> { // week8 미션

    // week9 미션 - 특정 가게 미션 목록 조회
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest); // store를 통해 미션 목록을 가져감
}
