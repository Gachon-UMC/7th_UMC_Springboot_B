package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "region",cascade=CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Store> storeList = new ArrayList<>();

    public void addStore(Store store) {
        storeList.add(store);
        store.setRegion(this);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
        store.setRegion(null);
    }
}

