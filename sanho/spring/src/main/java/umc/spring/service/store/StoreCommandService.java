package umc.spring.service.store;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService { // week8 미션

    Store addStore(StoreRequestDTO.AddStoreDto request);
}
