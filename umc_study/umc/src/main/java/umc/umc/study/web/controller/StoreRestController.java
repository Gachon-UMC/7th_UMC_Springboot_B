package umc.umc.study.web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc.study.apiPayload.ApiResponse;
import umc.umc.study.converter.MemberConverter;
import umc.umc.study.converter.StoreConverter;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Store;
import umc.umc.study.service.StoreService.StoreCommandServiceImpl;
import umc.umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.umc.study.web.dto.StoreDTO.StoreRequestDto;
import umc.umc.study.web.dto.StoreDTO.StoreResponseDto;

@RestController
@RequestMapping("/stores")
public class StoreRestController {
    @Autowired
    private StoreCommandServiceImpl storeService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDto.JoinResultDTO> addStore(@RequestBody @Valid StoreRequestDto.JoinDto request) {
        Store storename = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(storename));
    }


}
