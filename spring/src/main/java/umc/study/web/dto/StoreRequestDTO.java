package umc.study.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.enums.Status;

@Getter
public class StoreRequestDTO {

    @NotBlank
    @Size(max = 50, message = "가게 이름을 50자를 넘기지 마십쇼")
    private String storeName;

    @NotBlank
    private String address;

    @NotNull
    private Long foodId;

    @NotNull
    private Status status;
}
