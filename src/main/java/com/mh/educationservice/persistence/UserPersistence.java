package com.mh.educationservice.persistence;

import com.mh.educationservice.domain.user.User;
import com.mh.educationservice.persistence.entities.UserEntity;
import com.mh.educationservice.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserPersistence {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity().fromDomain(user);
        return userRepository.save(userEntity).toDomain();
    }

    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserEntity::toDomain)
                .orElse(null);
    }
}
