package umc.umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.*;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
    Page<Mission> findAllByUsers(Users users, PageRequest pageRequest);
}
