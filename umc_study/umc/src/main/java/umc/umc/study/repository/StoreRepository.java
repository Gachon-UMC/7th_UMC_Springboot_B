package umc.umc.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    //List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}


