package umc.spring.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom { // 구현이 아닌 단순 확장이라 extends
}
