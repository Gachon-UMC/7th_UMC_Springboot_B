package umc.study.service.UserService;

import umc.study.domain.User;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);
    UserResponseDTO.JoinResultDTO join(UserRequestDTO.JoinDto request);
}
