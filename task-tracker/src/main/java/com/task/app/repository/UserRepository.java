package com.task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.app.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
