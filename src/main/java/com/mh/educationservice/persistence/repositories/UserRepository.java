package com.mh.educationservice.persistence.repositories;

import com.mh.educationservice.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
}