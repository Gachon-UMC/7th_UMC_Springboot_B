package umc.umc.study.web.dto.StoreDTO;

import com.querydsl.core.types.dsl.StringPath;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.umc.study.domain.QStore;

import java.util.List;


public class StoreRequestDto {
    @Getter
    public static class JoinDto{
        String name;
        String location;
        Long id;
    }

    public @NotBlank(message = "지역 정보는 필수입니다.") StringPath getLocation() {
        return QStore.store.location;
    }

    public @NotBlank(message = "가게 이름은 필수입니다.") StringPath getName() {
        return QStore.store.name;
    }
}

