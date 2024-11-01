package umc.jpa_ex.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.jpa_ex.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating; // 리뷰 별점

    private String content; // 리뷰 내용, String은 기본이 varchar(255)

    @Column(columnDefinition = "TEXT")
    private String reviewPictureUrl; // 리뷰 사진 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

}


