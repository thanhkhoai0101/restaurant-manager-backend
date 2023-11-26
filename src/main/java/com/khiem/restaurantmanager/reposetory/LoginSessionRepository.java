package com.khiem.restaurantmanager.reposetory;

import com.khiem.restaurantmanager.entity.LoginSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginSessionRepository extends JpaRepository<LoginSession, Long> {
    Optional<LoginSession> findByToken(String rawToken);
}