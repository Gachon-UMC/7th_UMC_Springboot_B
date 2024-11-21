package umc.study.service.StoreService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

@Component
public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float rating);
}
