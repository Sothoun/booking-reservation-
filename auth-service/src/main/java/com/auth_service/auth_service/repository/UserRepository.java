package com.auth_service.auth_service.repository;

import com.auth_service.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    List<User> findAllByStatus(String status);
    Optional<User> findByUsername(String username);

}
