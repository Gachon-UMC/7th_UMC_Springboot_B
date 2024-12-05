package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.ArrayList;
import java.util.List;

public class MemberRequestDTO { // week8 미션

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotBlank
        @Email
        String email; // 이메일 필드 추가

        @NotBlank
        String password; // 비밀번호 필드 추가

        @NotNull
        Integer gender;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @Size(min = 5, max = 12)
        String address;

        @Size(min = 5, max = 12)
        String specAddress;

        @ExistCategories
        List<Long> preferCategory = new ArrayList<>();

        @NotNull
        Role role; // 역할 필드 추가
    }
}