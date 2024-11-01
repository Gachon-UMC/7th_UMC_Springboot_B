package umc.jpa_ex.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.jpa_ex.domain.common.BaseEntity;
import umc.jpa_ex.domain.embedded.Address;
import umc.jpa_ex.domain.enums.StoreStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String information; // 가게 정보

    @Column(columnDefinition = "TEXT")
    private String storePictureUrl; // 가게 사진 URL

    @Embedded
    private Address address;

    @Column(nullable = false, length = 20)
    private String foodCategory; // 가게 음식 카테고리

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    private String description; // 가게 소개글

    private Double rating; // 가게 별점

    private int reviewCount; // 가게 리뷰 개수

    private String operationHour; // 가게 운영 시간

    private String closeDay; // 가게 휴무일

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private StoreStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();
}
