package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreDTO.StoreRequestDTO;
import umc.study.web.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request){


        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .build();
    }
}
