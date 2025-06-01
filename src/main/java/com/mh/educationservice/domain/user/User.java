package com.mh.educationservice.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;
    private UserRole role;
}
