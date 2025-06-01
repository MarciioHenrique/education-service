package com.mh.educationservice.controllers.requests;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.domain.user.UserRole;

public record RegisterRequest(
        String name,
        String email,
        String password,
        UserRole role
) {
    public User toDomain() {
        return new User(
                name,
                email,
                password,
                role
        );
    }
}
