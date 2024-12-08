package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

//    @Query("SELECT m FROM Mission m WHERE m.store.id = :storeId")
//    Page<Mission> findAllByStoreId(@Param("storeId") Long storeId, PageRequest pageRequest);

    // Store 객체로 검색
    Page<Mission> findAllByStore(Store store, Pageable pageable);

    // Store ID로 검색
    @Query("SELECT m FROM Mission m WHERE m.store.id = :storeId")
    Page<Mission> findAllByStoreId(@Param("storeId") Long storeId, Pageable pageable);


}
