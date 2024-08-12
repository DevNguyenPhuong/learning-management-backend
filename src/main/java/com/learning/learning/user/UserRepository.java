package com.learning.learning.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    @NonNull
    Optional<User> findById(@NonNull String id);
    boolean existsByUsername(String username);
}

