package com.superwalletuser.controller;


import com.superwalletuser.model.entity.User;
import com.superwalletuser.model.request.UserRequest;
import com.superwalletuser.model.response.UserResponse;
import com.superwalletuser.service.UserService;
import com.superwalletuser.validator.UserValidator;
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

    private final UserService userService;
    private final UserValidator validator;

    @PostMapping
    public ResponseEntity<UserResponse> crreateUser(@RequestBody @Valid UserRequest request){
        validator.validate(request);
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
        var response = userService.getUserbyId(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/desactivate")
    public ResponseEntity desactivateUser(@PathVariable UUID  id) {
        userService.desactivateUser(id);
        return ResponseEntity.noContent().build();
    }
}
