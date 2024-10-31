package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String mission_description;

    private Integer mission_point;

    private LocalDateTime deadline;

    private LocalDate inactiveDate;

    private String status;

    @OneToMany(mappedBy = "mission",cascade=CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

}