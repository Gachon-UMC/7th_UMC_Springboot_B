package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
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
    private Integer id;

    private String food_name;

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();

    @OneToMany(mappedBy = "food",cascade=CascadeType.ALL)
    private List<UserFavoriteFoods> userFavoriteFoodsList = new ArrayList<>();

}
