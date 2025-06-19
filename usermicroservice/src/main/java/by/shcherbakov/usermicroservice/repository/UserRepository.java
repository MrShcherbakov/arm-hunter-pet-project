package by.shcherbakov.usermicroservice.repository;

import by.shcherbakov.core_domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
