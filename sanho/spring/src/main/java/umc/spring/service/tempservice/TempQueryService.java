package umc.spring.service.tempservice;

import org.springframework.stereotype.Service;

@Service
public interface TempQueryService {

    void checkFlag(Integer flag);
}