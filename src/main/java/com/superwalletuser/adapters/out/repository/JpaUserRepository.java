package com.superwalletuser.adapters.out.repository;

import com.superwalletuser.adapters.out.repository.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {

    Optional<JpaUserEntity> findByEmailOrDocument(String email, String document);
    List<JpaUserEntity> findByIsActiveTrue();
}
