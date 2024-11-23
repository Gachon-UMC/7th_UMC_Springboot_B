package umc.umc.study.converter;

import umc.umc.study.domain.Gender;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Store;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.umc.study.web.dto.StoreDTO.StoreRequestDto;
import umc.umc.study.web.dto.StoreDTO.StoreResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {
    public static StoreResponseDto.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDto.JoinResultDTO.builder()
                .store_id(store.getId())
                .store_name(store.getName())
                .location(store.getLocation())
                .build();
    }

    public static Store toStore(StoreRequestDto.JoinDto request){

        return Store.builder()
                .location(request.getLocation())
                .id(request.getId())
                .name(request.getName())
                .build();
    }


}
