package com.superwalletuser.application.validator;

import com.superwalletuser.infraestructure.exception.BusinessException;
import com.superwalletuser.domain.request.UserRequest;
import com.superwalletuser.adapters.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserValidator {


    private final UserRepository userRepository;
    public void validate(UserRequest request) {

        userRepository.findByEmailOrDocument(request.getEmail(), request.getDocument()).ifPresent(u -> {
            throw new BusinessException("User with given email or document already exists");
        });

    }

    public void validateUser(UUID id) {
        userRepository.findById(id).ifPresent(u -> {
            throw new BusinessException("User with given id already exists");
        });
    }
}
