package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserFavoriteFoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;


    public void setUser(User user) {
        updateUserRelationship(user);
    }

    public void setFood(Food food) {
        updateFoodRelationship(food);
    }

    private void updateUserRelationship(User newUser) {
        // 기존 관계 해제
        if (this.user != null) {
            this.user.getUserFavoriteFoodsList().remove(this);
        }
        // 새 관계 설정
        this.user = newUser;
        if (newUser != null) {
            newUser.getUserFavoriteFoodsList().add(this);
        }
    }

    private void updateFoodRelationship(Food newFood) {
        // 기존 관계 해제
        if (this.food != null) {
            this.food.getUserFavoriteFoodsList().remove(this);
        }
        // 새 관계 설정
        this.food = newFood;
        if (newFood != null) {
            newFood.getUserFavoriteFoodsList().add(this);
        }
    }

}