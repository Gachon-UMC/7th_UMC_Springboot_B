package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.study.domain.enums.Gender;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String user_name;

    @Enumerated(EnumType.STRING) // STRING 명시 -> 글자로 판별하겠다 & 만약 명시안하면 그냥 인덱스별로
    private Gender gender;

    @Column(nullable = false)
    private LocalDate userBirth;

    private String userAddress;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean userLogin;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer userPoint;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private LocalDate inactive_date;

    @Column(unique = true)
    private String userEmail;

    @Column(unique = true)
    private String userPhone;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<UserFavoriteFoods> userFavoriteFoodsList = new ArrayList<>();
}


