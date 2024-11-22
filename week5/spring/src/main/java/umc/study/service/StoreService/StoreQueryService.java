package umc.study.service.StoreService;

import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<umc.study.domain.Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}