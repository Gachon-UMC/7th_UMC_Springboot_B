package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setUser(User user) {
        if (this.user != null) {
            this.user.getUserMissionList().remove(this);
        }
        this.user = user;
        if (user != null && !user.getUserMissionList().contains(this)) {
            user.getUserMissionList().add(this);
        }
    }

    public void setMission(Mission mission) {
        if (this.mission != null) {
            this.mission.getUserMissionList().remove(this);
        }
        this.mission = mission;
        if (mission != null && !mission.getUserMissionList().contains(this)) {
            mission.getUserMissionList().add(this);
        }
    }

    // 유효성 검증 메서드
    public void validate() {
        if (user == null) {
            throw new IllegalArgumentException("유저가 있어야 합니다.");
        }
        if (mission == null) {
            throw new IllegalArgumentException("미션이 있어야 합니다.");
        }
    }


}