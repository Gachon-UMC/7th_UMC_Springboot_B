package umc.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreDTO.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

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

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){

        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){

        Store store = storeRepository.findById(storeId).get();

        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return storePage;
    }

}
