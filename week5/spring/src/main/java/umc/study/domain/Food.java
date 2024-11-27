package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food {

    // 음식의 종류는 정해져 있음 -> AUTO_INCREMENT 사용 X
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String foodName;

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Store> storeList = new ArrayList<>();

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<UserFavoriteFoods> userFavoriteFoodsList = new ArrayList<>();
}
