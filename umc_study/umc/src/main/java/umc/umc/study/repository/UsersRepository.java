package umc.umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc.study.domain.Mission;
import umc.umc.study.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
