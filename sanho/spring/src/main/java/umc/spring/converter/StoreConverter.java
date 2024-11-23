package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class StoreConverter { // week8 미션

    public static StoreResponseDTO.AddStoreDTO toAddResultDTO(Store store){
        return StoreResponseDTO.AddStoreDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDto request, Region region){ // name, address, region

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .reviewList(new ArrayList<>())
                .build();
    }

}
