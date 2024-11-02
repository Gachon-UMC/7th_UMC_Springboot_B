package umc.spring.service.store;

import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id); // null 반환 가능
    List<Store> findStoresByNameAndScore(String name, Float score);
}
