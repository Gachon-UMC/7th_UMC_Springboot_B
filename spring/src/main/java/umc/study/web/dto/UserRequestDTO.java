package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {
    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String userName;

        @NotBlank
        @Email
        String userEmail;    // 이메일 필드 추가

        @NotBlank
        String password;    // 비밀번호 필드 추가

        @NotNull
        String gender;

        @NotNull
        LocalDate userBirth;

        @Size(min = 3, max = 10)
        String userAddress;

        @ExistCategories
        List<Long> favoriteFoodIds;

        @NotNull
        Role role;    // 역할 필드 추가
    }
}
