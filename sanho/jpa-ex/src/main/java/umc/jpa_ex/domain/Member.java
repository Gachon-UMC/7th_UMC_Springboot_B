package umc.jpa_ex.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.jpa_ex.domain.common.BaseEntity;
import umc.jpa_ex.domain.embedded.Address;
import umc.jpa_ex.domain.enums.Gender;
import umc.jpa_ex.domain.enums.MemberStatus;
import umc.jpa_ex.domain.mapping.MemberAgree;
import umc.jpa_ex.domain.mapping.MemberMission;
import umc.jpa_ex.domain.mapping.SelectCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    private LocalDate birthdate; // date 타입이라 LocalDate

    @Embedded
    private Address address; // 내장 타입

    private int point;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private MemberStatus status;

    private LocalDateTime inactiveDate; // datetime 타입이므로 LocalDateTime

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // CascadeType.ALL로 인해 persist(member) 하면 같이 persist 됨.
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<SelectCategory> selectCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ReviewAlarm> reviewAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MarketingAlarm> marketingAlarmList = new ArrayList<>();
}
