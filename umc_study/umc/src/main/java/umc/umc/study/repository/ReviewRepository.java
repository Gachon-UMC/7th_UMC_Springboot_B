package umc.umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Member;
import umc.umc.study.domain.Review;
import umc.umc.study.domain.Store;
import umc.umc.study.domain.Users;

public interface ReviewRepository extends JpaRepository<Review, String> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByUsers(Users users, PageRequest pageRequest);
}
