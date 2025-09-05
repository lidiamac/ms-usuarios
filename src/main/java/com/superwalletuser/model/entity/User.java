package com.superwalletuser.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static java.time.LocalDateTime.now;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String document;
    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(STRING)
    private UserTypeEnum userType;

    private LocalDateTime createdAt;

    private Boolean isActive;

    @PrePersist
    public void prePersist() {
        createdAt = now();
        isActive = true;
    }

}
