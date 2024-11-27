package umc.study.service.RegionService;

import umc.study.apiPayload.exception.RegionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Food;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.FoodRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final FoodRepository foodRepository;

    @Transactional
    public StoreResponseDTO addStoreToRegion(Long regionId, StoreRequestDTO storeRequestDTO) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(RegionNotFoundException::new);

        Food food = foodRepository.findById(storeRequestDTO.getFoodId())
                .orElseThrow(() -> new IllegalArgumentException("ID로 음식을 찾을 수 없음 : " + storeRequestDTO.getFoodId()));

        Store store = StoreConverter.toEntity(storeRequestDTO, region, food);
        storeRepository.save(store);

        return StoreConverter.toResponseDTO(store);
    }
}