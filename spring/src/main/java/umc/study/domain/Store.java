package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.study.domain.enums.Status;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment + 인덱스 유지(앞의 인덱스가 삭제되어도)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(nullable = false, length = 50)
    private String storeName;

    @Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal storeScope = BigDecimal.ZERO;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "store",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    // 리뷰들의 평균값을 계산하여 storeScope를 업데이트하는 메서드
    public void updateStoreScope() {
        if (reviewList.isEmpty()) {
            this.storeScope = BigDecimal.ZERO;
            return;
        }

        BigDecimal total = reviewList.stream()
                .map(review -> new BigDecimal(review.getReviewScope().getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal average = total.divide(new BigDecimal(reviewList.size()), 2, RoundingMode.HALF_UP);
        this.storeScope = average;
    }

    // 리뷰 추가 메서드
    public void addReview(Review review) {
        reviewList.add(review);
        review.setStore(this);
    }

    // 리뷰 삭제 메서드
    public void removeReview(Review review) {
        reviewList.remove(review);
        review.setStore(null);
    }

    // 미션 추가 메서드
    public void addMission(Mission mission) {
        missionList.add(mission);
        mission.setStore(this);
    }

    // 미션 삭제 메서드
    public void removeMission(Mission mission) {
        missionList.remove(mission);
        mission.setStore(null);
    }

    // 지역 설정 메서드
    public void setRegion(Region region) {
        if (this.region != null) {
            this.region.getStoreList().remove(this);
        }
        this.region = region;
        if (!region.getStoreList().contains(this)) {
            region.getStoreList().add(this);
        }
    }
}
