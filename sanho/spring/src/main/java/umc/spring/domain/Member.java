package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.MemberAgree;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // JPA의 엔티티
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA가 통신하는 DBMS의 방식을 따른다. - Mysql
    private Long id;

    @Column(nullable = false, length = 20) // 널 값 허용하지 않음
    private String name;

//    @Column(columnDefinition = "VARCHAR(20)") // 널 값 허용
//    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @Column(columnDefinition = "DATETIME")
    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("0")
    private Integer point;

    // 나이 추가
    private Integer age;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // CascadeType.ALL로 인해 persist(member) 하면 아래 4개도 같이 persist 됨.
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}

/** 
 * 정리
 * 1. 각 도메인 다 만들기
 * 이 때 created_at과 updated_at은 BaseEntity로 빼고 상속 받기, Application에 @EnableJpaAuditing도 넣어줘야되
 * 2. 매핑 테이블 만들기
 * 3. 연관관계 매핑 @ManyToOne (단방향 매핑) - FK 갖는 연관관계 주인 기준
 *  ex) @ManyToOne, @JoinColumn
 *  4. 연관관계 매핑 @OneToMany (양방향 매핑) - 수정/삭제 많이 안 하는 엔티티는 양방향 설정 안 해도 됨. - 연관관계 주인 반대
 * @ManyToOne 한 것을 @OneToMany로 받아야 됨.
 * 5. 칼럼 별 세부적 설정 @Column
 * */