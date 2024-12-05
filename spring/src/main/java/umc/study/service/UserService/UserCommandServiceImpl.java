package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserFavoriteFoodConverter;
import umc.study.domain.Food;
import umc.study.domain.User;
import umc.study.domain.UserFavoriteFoods;
import umc.study.domain.enums.Gender;
import umc.study.repository.UserRepository.FoodRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    private final FoodRepository foodRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User user = UserConverter.toUser(request);

        user.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Food> foodList = request.getFavoriteFoodIds().stream()
                .map(categoryId ->
                        foodRepository.findById(categoryId)
                                .orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))
                ).collect(Collectors.toList());

        List<UserFavoriteFoods> userFavoriteFoodsList = UserFavoriteFoodConverter.toUserFavoriteFoodsList(foodList);

        userFavoriteFoodsList.forEach(userFavoriteFoods -> {userFavoriteFoods.setUser(user);});

        userRepository.save(user);

        return user;

    }

    @Override
    public UserResponseDTO.JoinResultDTO join(UserRequestDTO.JoinDto request) {
        User user = joinUser(request);
        return UserConverter.toJoinResultDTO(user);
    }
}
