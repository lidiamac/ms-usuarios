package com.superwalletuser.service;

import com.superwalletuser.exception.BusinessException;
import com.superwalletuser.model.assembler.UserAssembler;
import com.superwalletuser.model.request.UserRequest;
import com.superwalletuser.model.response.UserResponse;
import com.superwalletuser.repository.UserRepository;
import com.superwalletuser.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final UserAssembler userAssembler;


    public UserResponse createUser(UserRequest request) {
        var entity = userAssembler.toEntity(request);
        userRepository.save(entity);
        return userAssembler.toResponse(entity);
    }

    public UserResponse getUserbyId(UUID id) {
        return userRepository.findById(id)
                .map(entity -> userAssembler.toResponse(entity))
                .orElseThrow(() -> new BusinessException("User not found"));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(entity -> userAssembler.toResponse(entity))
                .collect(Collectors.toList());
    }

    public List<UserResponse> getAlActivelUsers() {
        return userRepository.findByIsActiveTrue().stream()
                .map(entity -> userAssembler.toResponse(entity))
                .collect(Collectors.toList());
    }

    public void desactivateUser(UUID id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));

        entity.setIsActive(false);

        userRepository.save(entity);
    }
}
