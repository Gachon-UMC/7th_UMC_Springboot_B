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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String foodName;

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL)
    private List<UserFavoriteFoods> userFavoriteFoodsList = new ArrayList<>();

}
