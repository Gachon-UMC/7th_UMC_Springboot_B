package umc.spring.service.tempservice;

import org.springframework.stereotype.Service;

@Service
public interface TempQueryService { // 인터페이스

    void checkFlag(Integer flag);
}