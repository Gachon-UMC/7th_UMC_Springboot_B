package umc.spring.service.tempservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{ // Service에서 예외를 터뜨림

    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION); // 이건 그냥 flag가 1일 때의 예시이고, 실제로는 필요한 곳에서 해당 예외를 터뜨림
        // 여기서 Controller로 안 가고 바로 Exception handler에 의해 응답이 보내짐. @RestControllerAdvice
    }
}