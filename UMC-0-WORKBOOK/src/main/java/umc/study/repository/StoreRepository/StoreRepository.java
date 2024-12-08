package umc.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}
