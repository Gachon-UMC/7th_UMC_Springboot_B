package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;

    public StoreQueryServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Transactional
    @Override
    public List<Store> findStoresByNameAndScore(String name, Float rating) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, rating);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
}
