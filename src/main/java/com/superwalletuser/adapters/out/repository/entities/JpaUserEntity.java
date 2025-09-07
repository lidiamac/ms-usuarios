package com.superwalletuser.adapters.out.repository.entities;

import com.superwalletuser.domain.entity.User;
import com.superwalletuser.domain.entity.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static java.time.LocalDateTime.now;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
public class JpaUserEntity {

    public JpaUserEntity(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.document = user.getDocument();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.userType = user.getUserType();
    }

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
