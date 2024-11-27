package umc.study.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.study.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @NotBlank
    @Size(min = 5, max = 255)
    @Column(nullable = false)
    private String missionDescription;

    @NotNull
    @Column(nullable = false)
    private Integer missionPoint;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime deadline;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "mission",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<UserMission> userMissionList = new ArrayList<>();

    public void setStore(Store store) {
        if (this.store != null && this.store.getMissionList() != null) {
            this.store.getMissionList().remove(this);
        }
        this.store = store;
        if (store != null && !store.getMissionList().contains(this)) {
            store.getMissionList().add(this);
        }
    }

    // 데이터 무결성 검증
    public void validate() {
        if (missionPoint == null || missionPoint <= 0) {
            throw new IllegalArgumentException("미션 보상 포인트는 반드시 0 포인트 이상이어야 합니다.");
        }
        if (deadline == null || deadline.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Deadline은 반드시 미래의 시간대여야 합니다.");
        }
    }
}