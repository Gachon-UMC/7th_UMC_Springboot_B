package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.math.BigDecimal;

public class StoreConverter {

    public static Store toEntity(StoreRequestDTO request, Region region, Food food) {
        return Store.builder()
                .storeName(request.getStoreName())
                .address(request.getAddress())
                .status(request.getStatus())
                .storeScope(BigDecimal.ZERO)
                .region(region)
                .food(food) // food 설정
                .build();
    }

    public static StoreResponseDTO toResponseDTO(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .storeName(store.getStoreName())
                .address(store.getAddress())
                .status(store.getStatus())
                .storeScope(store.getStoreScope())
                .regionId(store.getRegion().getId())
                .id(store.getFood().getId()) // food_id 포함
                .build();
    }
}
