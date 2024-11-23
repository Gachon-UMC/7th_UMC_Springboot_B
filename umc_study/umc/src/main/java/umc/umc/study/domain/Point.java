package umc.umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;



    @Column(nullable = false)
    private Integer point;

    @UpdateTimestamp
    private LocalDateTime cleartime;

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<Mission> MissionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Users users;
}
