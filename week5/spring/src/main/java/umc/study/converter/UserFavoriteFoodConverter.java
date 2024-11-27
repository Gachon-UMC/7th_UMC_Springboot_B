package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.UserFavoriteFoods;

import java.util.List;
import java.util.stream.Collectors;

public class UserFavoriteFoodConverter {
    public static List<UserFavoriteFoods> toUserFavoriteFoodsList(List<Food> foodList){

        return foodList.stream()
                .map(food ->
                        UserFavoriteFoods.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}
