package com.superwalletuser.validator;

import com.superwalletuser.exception.BusinessException;
import com.superwalletuser.model.request.UserRequest;
import com.superwalletuser.repository.UserRepository;
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
