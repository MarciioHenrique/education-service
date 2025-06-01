package com.mh.educationservice.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private String key = null;
    @NotBlank
    @NonNull
    private String name;
    @Email
    @NonNull
    private String email;
    @NotBlank
    @NonNull
    private String password;
    @NonNull
    private UserRole role;
}
