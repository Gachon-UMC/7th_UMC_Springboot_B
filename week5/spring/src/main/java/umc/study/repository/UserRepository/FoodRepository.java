package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Food;

// 이게 Long이 맞나?
public interface FoodRepository extends JpaRepository<Food, Long> {
}
