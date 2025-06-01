package com.mh.educationservice.controllers.responses;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.domain.user.UserRole;

public record RegisterResponse(
        String key,
        String name,
        String email,
        UserRole role
) {
    public static RegisterResponse fromDomain(User user) {
        return new RegisterResponse(
                user.getKey(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
