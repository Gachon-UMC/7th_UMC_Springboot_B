package umc.umc.study.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.umc.study.converter.StoreConverter;
import umc.umc.study.domain.Store;
import umc.umc.study.repository.StoreRepository.StoreRepository;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.StoreDTO.StoreRequestDto;

@Service
public class StoreCommandServiceImpl {
    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(StoreRequestDto.JoinDto request) {
        Store store = StoreConverter.toStore(request);
        Store savedStore = storeRepository.save(store);
        return savedStore;
    }
}
