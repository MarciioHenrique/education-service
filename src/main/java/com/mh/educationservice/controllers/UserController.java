package com.mh.educationservice.controllers;

import com.mh.educationservice.controllers.dtos.response.UserResponse;
import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(UserResponse.fromDomain(createdUser));
    }
}
