package umc.umc.study.domain;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Boss boss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region")
    private Region region;

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
