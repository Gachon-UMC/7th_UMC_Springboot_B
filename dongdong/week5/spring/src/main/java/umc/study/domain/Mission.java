package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false)
    private String mission_description;

    @Column(nullable = false)
    private Integer mission_point;

    @Column(nullable = false)
    private LocalDateTime deadline;

    private LocalDate inactiveDate;

    @Column(length = 15, nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private String status;

    @OneToMany(mappedBy = "mission",cascade=CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

}