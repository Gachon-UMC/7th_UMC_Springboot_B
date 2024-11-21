package umc.study.web.dto.MemberDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistsCategories;

import java.time.LocalDateTime;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotBlank
        String address;

        @NotNull
        Integer age;

        @NotBlank
        String email;

        @NotNull
        Integer point;

        @NotBlank
        String phoneNumber;

        @NotNull
        LocalDateTime inactiveDate;

        @NotNull
        Integer gender;

        @NotBlank
        String type;

        @NotBlank
        String status;

        @ExistsCategories
        List<Long> preferCategory;

    }
}
