package com.mh.educationservice.services;

import com.mh.educationservice.controllers.requests.LoginRequest;
import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.persistence.UserPersistence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserPersistence userPersistence;

    public User register(User user) {
        if (userPersistence.userExistsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        return userPersistence.saveUser(user);
    }

    public User login(LoginRequest request) {
        User user = userPersistence.findByEmail(request.email());
        if (user == null || !user.getPassword().equals(request.password())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return user;
    }
}
