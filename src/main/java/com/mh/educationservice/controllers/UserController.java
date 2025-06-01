package com.mh.educationservice.controllers;

import com.mh.educationservice.controllers.requests.LoginRequest;
import com.mh.educationservice.controllers.requests.RegisterRequest;
import com.mh.educationservice.controllers.responses.LoginResponse;
import com.mh.educationservice.controllers.responses.RegisterResponse;
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
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        User createdUser = userService.register(request.toDomain());
        return ResponseEntity.ok(RegisterResponse.fromDomain(createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        User user = userService.login(request);
        return ResponseEntity.ok(LoginResponse.fromToken(user.getKey(), "token"));
    }
}
