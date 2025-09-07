package com.superwalletuser.adapters.out.repository;

import com.superwalletuser.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmailOrDocument(String email, String document);
    List<User> findByIsActiveTrue();

}
