package umc.umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc.study.apiPayload.ApiResponse;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.domain.Member;
import umc.umc.study.service.MemberService.MemberCommandService;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;



@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}