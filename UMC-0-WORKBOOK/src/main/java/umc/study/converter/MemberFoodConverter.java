package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {

    public static List<MemberFood> toMemberFoodList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
