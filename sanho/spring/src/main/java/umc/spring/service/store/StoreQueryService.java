package umc.spring.service.store;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id); // null 반환 가능
    List<Store> findStoresByNameAndScore(String name, Float score);

    // week9 코드
    Page<Review> getReviewList(Long storeId, Integer page); // Page 자체에 페이징과 관련된 여러 정보가 담김 -> Paging을 위한 추상화 제공

    // week9 미션 - 특정 가게 미션 목록 조회
    Page<Mission> getMissionList(Long storeId, Integer page);
}
