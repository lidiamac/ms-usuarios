package com.superwalletuser.application.usecases;

import com.superwalletuser.domain.request.UserRequest;
import com.superwalletuser.domain.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserUseCases {

    UserResponse createUser(UserRequest request);
    UserResponse findUserById(UUID id);
    List<UserResponse> getAllUsers();
    List<UserResponse> getAlActivelUsers();
    void desactivateUser(UUID id);
}
