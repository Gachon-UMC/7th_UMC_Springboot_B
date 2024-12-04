package umc.umc.study.service.Users;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc.study.converter.UsersConverter;
import umc.umc.study.domain.Users;
import umc.umc.study.repository.UsersRepository;
import umc.umc.study.web.dto.UsersDTO.UserRequestDto;


@Service
@RequiredArgsConstructor
public class UsersCommandServiceImpl implements UsersCommandService {

    private final UsersRepository usersRepository;

    @Transactional
    public Users adduser(UserRequestDto.JoinDto request) {

        Users newuser_ms = UsersConverter.toUsers(request);

        return usersRepository.save(newuser_ms);
    }


}
