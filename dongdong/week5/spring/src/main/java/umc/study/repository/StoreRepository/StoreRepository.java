package umc.study.repository.StoreRepository;

import umc.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.repository.StoreRepository.StoreRepositoryCustom;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}