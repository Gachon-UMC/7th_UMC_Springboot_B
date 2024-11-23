package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

@Component
public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float rating);
    Page<Review> getReviewList(Long storeId, Integer page);
}
