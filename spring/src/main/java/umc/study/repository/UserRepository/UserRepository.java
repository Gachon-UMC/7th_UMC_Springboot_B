package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String userEmail);
}