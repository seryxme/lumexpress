package com.hotsystemsng.lumexpress.data.repositories;

import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import com.hotsystemsng.lumexpress.exceptions.VerificationTokenException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class VerificationTokenRepositoryTest {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    private VerificationToken verificationToken;

    @BeforeEach
    void setUp() {
        verificationToken = new VerificationToken();
        verificationToken.setToken("12345");
        verificationToken.setUserEmail("test@gmail.com");
    }

    @Test
    void findByUserEmail() {
        verificationTokenRepository.save(verificationToken);
        var foundToken = verificationTokenRepository
                .findByUserEmail("test@gmail.com")
                .orElseThrow(()-> new VerificationTokenException("Token not found."));
        log.info("found token ::{}", foundToken);
        assertThat(foundToken).isNotNull();
        assertThat(foundToken.getToken()).isEqualTo(verificationToken.getToken());
    }

    @Test
    void findByToken() {
        verificationTokenRepository.save(verificationToken);
        var foundToken = verificationTokenRepository
                .findByToken(verificationToken.getToken())
                .orElseThrow(()-> new VerificationTokenException("Token not found."));
        log.info("found token ::{}", foundToken);
        assertThat(foundToken).isNotNull();
        assertThat(foundToken.getToken()).isEqualTo("12345");
    }
}