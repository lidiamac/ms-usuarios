package com.superwalletuser.domain.entity;


import com.superwalletuser.adapters.out.repository.entities.JpaUserEntity;

import java.time.LocalDateTime;
import java.util.UUID;



public class User {


    private UUID id;
    private String name;

    private String document;
    private String password;
    private String email;
    private UserTypeEnum userType;
    private LocalDateTime createdAt;
    private Boolean isActive;

    public User (){}

    public User(UUID id, String name, String document, String password, String email, UserTypeEnum userType, LocalDateTime createdAt, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

    public User (JpaUserEntity jpaUserEntity){
        this.id = jpaUserEntity.getId();
        this.name = jpaUserEntity.getName();
        this.document = jpaUserEntity.getDocument();
        this.password = jpaUserEntity.getPassword();
        this.email = jpaUserEntity.getEmail();
        this.userType = jpaUserEntity.getUserType();
        this.createdAt = jpaUserEntity.getCreatedAt();
        this.isActive = jpaUserEntity.getIsActive();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
