package umc.umc.study.repository.StoreRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}


