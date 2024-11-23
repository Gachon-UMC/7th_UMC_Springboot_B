package umc.umc.study.service.Users;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import umc.umc.study.domain.Users;
import umc.umc.study.web.dto.UsersDTO.UserRequestDto;


public interface UsersCommandService {
    Users adduser(UserRequestDto.@Valid JoinDto request);
}
