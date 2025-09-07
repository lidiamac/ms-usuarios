package com.superwalletuser.application.service;

import com.superwalletuser.adapters.out.repository.UserRepositoryImpl;
import com.superwalletuser.application.usecases.UserUseCases;
import com.superwalletuser.application.validator.UserValidator;
import com.superwalletuser.infraestructure.exception.BusinessException;
import com.superwalletuser.util.mappers.UserAssembler;
import com.superwalletuser.domain.request.UserRequest;
import com.superwalletuser.domain.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserUseCases {

    private final UserRepositoryImpl userRepository;
    private final UserValidator userValidator;
    private final UserAssembler userAssembler;

    @Override
    public UserResponse createUser(UserRequest request) {
       var entity = userAssembler.toEntity(request);
        userValidator.validate(entity);
        return userAssembler.toResponse(userRepository.save(entity));
    }

    @Override
    public UserResponse findUserById(UUID id) {
        return userRepository.findById(id)
                .map(entity -> userAssembler.toResponse(entity))
                .orElseThrow(() -> new BusinessException("User not found"));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(entity -> userAssembler.toResponse(entity))
                .collect(toList());
    }

    @Override
    public List<UserResponse> getAlActivelUsers() {
        return userRepository.findByIsActiveTrue().stream()
                .map(entity -> userAssembler.toResponse(entity))
                .collect(toList());
    }

    @Override
    public void desactivateUser(UUID id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));
        entity.setIsActive(false);
        userRepository.save(entity);
    }

}
