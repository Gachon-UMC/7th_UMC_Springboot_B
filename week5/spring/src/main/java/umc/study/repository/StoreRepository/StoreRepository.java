package umc.study.repository.StoreRepository;

import umc.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.repository.StoreRepository.StoreRepositoryCustom;

// 이 놈은 StoreRepository의 근본
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    boolean existsById(Long id); // 추가
}