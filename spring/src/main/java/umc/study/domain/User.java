package umc.study.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Gender는 필수값으로 처리
    private Gender gender;

    @Column(nullable = true)
    private LocalDate userBirth;

    private String userAddress;

    @Builder.Default
    private Boolean userLogin = false;

    @Builder.Default
    private Integer userPoint = 0;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private LocalDate inactive_date;

    @Column(unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String userPhone;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, orphanRemoval = true)
    private List<UserFavoriteFoods> userFavoriteFoodsList = new ArrayList<>();

    public void encodePassword(String password) {
        this.password = password;
    }

//    public String getEmail() {
//        return this.userEmail;
//    }
}


