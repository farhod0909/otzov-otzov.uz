package uz.protshm.recommenduz.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.Users;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsernameAndDeletedFalse(String username);
}
