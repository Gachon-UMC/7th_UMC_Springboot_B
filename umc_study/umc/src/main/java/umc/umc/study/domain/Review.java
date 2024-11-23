package umc.umc.study.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "re_user_id")
    private Users users;


    @Column(nullable = false)
    private Integer rating;

    private String image_url;

    @Column(length = 200)
    private String review;

    private String favorite_food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "re_store_id")
    private Store store;

    public void setReview(String review){
        this.review = review;
    }
    public void setRating(Integer rating){
        this.rating = rating;
    }
}
