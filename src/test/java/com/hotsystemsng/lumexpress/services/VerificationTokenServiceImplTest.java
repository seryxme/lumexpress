package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import com.hotsystemsng.lumexpress.data.repositories.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class VerificationTokenServiceImplTest {

    @Autowired
    private VerificationTokenService verificationTokenService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateVerificationTokenTest() {
        VerificationToken verificationToken = verificationTokenService
                .generateVerificationToken("test@email.com");
        log.info("token-->{}", verificationToken);
        assertThat(verificationToken).isNotNull();
        assertThat(verificationToken.getToken().length()).isEqualTo(5);
    }
}