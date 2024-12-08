package umc.study.web.dto.MemberDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistsCategories;

import java.time.LocalDateTime;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotBlank
        @Size(min = 5, max = 12)
        String address;

        @NotNull
        Integer age;

        @Email
        String email;

        @NotNull
        Integer point;

        @NotBlank
        String phoneNumber;

        @NotNull
        LocalDateTime inactiveDate;

        @NotNull
        Integer gender;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @NotBlank
        String type;

        @NotBlank
        String status;

        @Size(min = 5, max = 12)
        String specAddress;

        @ExistsCategories
        List<Long> preferCategory;

        @NotBlank
        String password;

        @NotNull
        Role role;

    }
}
