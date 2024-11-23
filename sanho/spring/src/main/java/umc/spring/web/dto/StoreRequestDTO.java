package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO { // week8 미션

    @Getter
    public static class AddStoreDto {

        @NotBlank
        String name;

        @NotNull
        String address;

        @ExistRegion
        Long regionId;
    }
}
