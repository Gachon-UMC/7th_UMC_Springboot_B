package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter { // TempResponse.TempTestDTO의 형태로 바꿔주는 역할

    public static TempResponse.TempTestDTO toTempTestDTO(){   // static으로 선언
        return TempResponse.TempTestDTO.builder()   // 응답도 builder 패턴으로 생성
                .testString("This is Test!")  // 이게 result 값
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}