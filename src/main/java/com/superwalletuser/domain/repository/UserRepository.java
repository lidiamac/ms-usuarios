package com.superwalletuser.domain.repository;

import com.superwalletuser.adapters.out.repository.JpaUserRepository;
import com.superwalletuser.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAll();
    List<User> findByIsActiveTrue();
    Optional<User> findByEmailOrDocument(User user);
}
