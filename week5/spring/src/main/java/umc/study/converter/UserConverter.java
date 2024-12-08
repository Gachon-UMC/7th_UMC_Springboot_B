package umc.study.converter;

import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

//    public static User toUser(UserRequestDTO.JoinDto request){
//        return User.builder()
//                .userAddress(request.getUserAddress())
//                .gender(Gender.fromCode(request.getGender())) // Enum 변환
//                .user_name(request.getName())
//                .userBirth(request.getUserBirth())
//                .userFavoriteFoodsList(new ArrayList<>())
//                .build();
//    }
    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = Gender.fromString(request.getGender()); // Gender 변환

        return User.builder()
                .userAddress(request.getUserAddress())
                .gender(gender)
                .userName(request.getName())
                .userBirth(request.getUserBirth()) // 생일 추가 매핑
                .userFavoriteFoodsList(new ArrayList<>())
                .build();
    }


}

