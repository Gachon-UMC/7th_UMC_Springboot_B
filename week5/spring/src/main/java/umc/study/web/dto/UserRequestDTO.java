package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.enums.Gender;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotNull
        String gender;

        @NotNull
        LocalDate userBirth;

        @Size(min = 3, max = 10)
        String userAddress;

        @ExistCategories
        List<Long> favoriteFoodIds;
    }
}
