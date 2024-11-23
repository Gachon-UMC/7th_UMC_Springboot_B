package umc.umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc.study.apiPayload.ApiResponse;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.converter.UsersConverter;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Users;
import umc.umc.study.service.MemberService.MemberCommandService;
import umc.umc.study.service.Users.UsersCommandService;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.umc.study.web.dto.UsersDTO.UserRequestDto;
import umc.umc.study.web.dto.UsersDTO.UsersResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersRestController {
    private final UsersCommandService usersCommandService;

    @PostMapping("/")
    public ApiResponse<UsersResponseDto.JoinResultDTO> join(@RequestBody @Valid UserRequestDto.JoinDto request){
        Users users = usersCommandService.adduser(request);
        return ApiResponse.onSuccess(UsersConverter.toJoinResultDTO(users));
    }
}
