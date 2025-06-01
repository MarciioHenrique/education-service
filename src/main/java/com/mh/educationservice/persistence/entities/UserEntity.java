package com.mh.educationservice.persistence.entities;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.domain.user.UserRole;
import com.mh.educationservice.utils.KeyGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static com.mh.educationservice.utils.KeyPrefixes.USER_PREFIX;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "external_key", nullable = false, unique = true)
    private String key = KeyGenerator.generateWithPrefix(USER_PREFIX);

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    public UserEntity fromDomain(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        return this;
    }

    public User toDomain() {
        return new User(
                key,
                name,
                email,
                password,
                role
        );
    }
}
