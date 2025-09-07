package com.superwalletuser.application.validator;

import com.superwalletuser.adapters.out.repository.UserRepositoryImpl;
import com.superwalletuser.domain.entity.User;
import com.superwalletuser.infraestructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepositoryImpl userRepository;

    public void validate(User user) {

        userRepository.findByEmailOrDocument(user).ifPresent(u -> {
            throw new BusinessException("User with given email or document already exists");
        });

    }

    public void validateUser(UUID id) {
        userRepository.findById(id).ifPresent(u -> {
            throw new BusinessException("User with given id already exists");
        });
    }
}
