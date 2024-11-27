package umc.study.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.study.domain.enums.ReviewScope;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String reviewImg;

    @Column(length = 500)
    @Size(max = 500, message = "Review content must be 500 characters or less.")
    private String reviewContent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewScope reviewScope;

    @CreatedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime updatedAt;

    public void setStore(Store store) {
        if (this.store != null && this.store.getReviewList() != null) {
            this.store.getReviewList().remove(this);
        }
        this.store = store;
        if (store != null && !store.getReviewList().contains(this)) {
            store.getReviewList().add(this);
        }
    }

    public void setUser(User user) {
        if (this.user != null && this.user.getReviewList() != null) {
            this.user.getReviewList().remove(this);
        }
        this.user = user;
        if (user != null && !user.getReviewList().contains(this)) {
            user.getReviewList().add(this);
        }
    }
}