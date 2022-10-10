package com.hotsystemsng.lumexpress.data.repositories;

import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByUserEmail(String userEmail);
    Optional<VerificationToken> findByToken(String token);
}
