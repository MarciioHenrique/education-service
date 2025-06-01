package com.mh.educationservice.controllers.responses;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.domain.user.UserRole;

public record UserResponse(
        String name,
        String email,
        UserRole role
) {
    public static UserResponse fromDomain(User user) {
        return new UserResponse(
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
