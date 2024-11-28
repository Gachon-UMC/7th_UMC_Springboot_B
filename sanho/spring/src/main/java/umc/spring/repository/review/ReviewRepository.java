package umc.spring.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> { // week8 미션

    Page<Review> findAllByStore(Store store, PageRequest pageRequest); // PageRequest는 페이징과 관련된 옵션이 포함

    // week9 미션 - 특정 멤버 리뷰 조회
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
