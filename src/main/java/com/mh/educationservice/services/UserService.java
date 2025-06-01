package com.mh.educationservice.services;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.persistence.UserPersistence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserPersistence userPersistence;

    public User createUser(User user) {
        if (userPersistence.userExistsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        return userPersistence.saveUser(user);
    }
}
