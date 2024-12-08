package umc.jpa_ex.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.jpa_ex.domain.common.BaseEntity;
import umc.jpa_ex.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터 삽입하면 자동 id를 넣어줌. 1,2,3,4,5에서 1 삭제 되어도 2,3,4,5 그대로 남아있음
    private Long id;

    private int reward;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
