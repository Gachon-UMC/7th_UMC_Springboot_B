package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(nullable = false, length = 50)
    private String store_name;

    @Column(nullable = false, length = 20)
    private String store_location;

    @Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal store_scope;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    private LocalDate inactiveDate;

    @Column(length = 15, nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private String status;

    @OneToMany(mappedBy = "store",cascade=CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store",cascade=CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}