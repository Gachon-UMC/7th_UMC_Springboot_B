package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.UserMission;
import umc.study.domain.enums.Status;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionId(Long userId, Long missionId);
    Page<UserMission> findAllByUserId(Long userId, Pageable pageable);

    Page<UserMission> findByUserIdAndMissionStatus(Long userId, Status status, Pageable pageable);

}
