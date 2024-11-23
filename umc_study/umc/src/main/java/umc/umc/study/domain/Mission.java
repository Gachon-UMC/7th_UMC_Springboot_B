package umc.umc.study.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer clear;



    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer store_id;

    @UpdateTimestamp
    private LocalDateTime cleartime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ms_id")
    private Point point;

    public void setMissionStatus(Integer clear, String title, Integer store_id) {
        this.clear = clear;
        this.title = title;
        this.store_id = store_id;
    }

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Users> userList = new ArrayList<>();

    @OneToMany(mappedBy = "mission_status", cascade = CascadeType.ALL)
    private List<Users> userList_status = new ArrayList<>();



}
