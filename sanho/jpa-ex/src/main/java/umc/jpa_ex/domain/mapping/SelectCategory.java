package umc.jpa_ex.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.jpa_ex.domain.FoodCategory;
import umc.jpa_ex.domain.Member;
import umc.jpa_ex.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SelectCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;
}
