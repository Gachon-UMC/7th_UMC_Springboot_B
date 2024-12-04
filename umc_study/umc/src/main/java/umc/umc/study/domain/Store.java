package umc.umc.study.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String name;

    private String menu;

    @Column(nullable = false)
    private Integer rating;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> ReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> MissionList = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boss")
    private Boss boss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region")
    private Region region;


    public Store(@NotBlank(message = "가게 이름은 필수입니다.") Long name, @NotBlank(message = "지역 정보는 필수입니다.") String location) {
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + location + '\'' +
                ", score=" + rating +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }

}
