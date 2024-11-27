package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.enums.Status;

import java.math.BigDecimal;

@Getter
@Builder
public class StoreResponseDTO {

    private Long id;
    private String storeName;
    private String address;
    private BigDecimal storeScope;
    private Long regionId;
    private Status status;
}
