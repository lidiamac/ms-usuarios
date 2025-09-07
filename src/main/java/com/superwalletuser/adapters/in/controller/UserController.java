package com.superwalletuser.adapters.in.controller;


import com.superwalletuser.application.service.UserServiceImpl;
import com.superwalletuser.application.validator.UserValidator;
import com.superwalletuser.domain.request.UserRequest;
import com.superwalletuser.domain.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final UserValidator validator;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest request){
        var response = userService.createUser(request);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active")
    public ResponseEntity<List<UserResponse>> getAllActiveUsers() {
        var response = userService.getAlActivelUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        var response = userService.findUserById(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/desactivate")
    public ResponseEntity desactivateUser(@PathVariable UUID  id) {
        userService.desactivateUser(id);
        return ResponseEntity.noContent().build();
    }
}
