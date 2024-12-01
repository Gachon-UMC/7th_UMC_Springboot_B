package umc.umc.study.converter;

import umc.umc.study.domain.Review;
import umc.umc.study.domain.Users;
import umc.umc.study.web.dto.ReviewDTO.ReviewRequestDto;
import umc.umc.study.web.dto.ReviewDTO.ReviewResponseDto;
import umc.umc.study.web.dto.UsersDTO.UserRequestDto;
import umc.umc.study.web.dto.UsersDTO.UsersResponseDto;

public class UsersConverter {

    public static UsersResponseDto.JoinResultDTO toJoinResultDTO(Users users){
        return UsersResponseDto.JoinResultDTO.builder()
                .missionId(users.getMission().getId())
                .userId(users.getId())
                .missionStatus(users.getMission_status().getClear())
                .build();
    }

    public static Users toUsers(UserRequestDto.JoinDto request){
        return Users.builder()
                .id(request.getId())
                .build();

    }
}
