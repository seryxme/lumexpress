package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.models.LumExpressUser;
import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import com.hotsystemsng.lumexpress.data.repositories.VerificationTokenRepository;
import com.hotsystemsng.lumexpress.exceptions.VerificationTokenException;
import com.hotsystemsng.lumexpress.utils.LumExpressUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;
    @Override
    public VerificationToken createToken(String userEmail) {
        String tokenString = LumExpressUtils.generateToken();
        VerificationToken verificationToken = VerificationToken.builder()
            .token(tokenString)
            .userEmail(userEmail)
            .createdAt(LocalDateTime.now())
            .expiresAt(LocalDateTime.now().plusMinutes(5))
            .build();
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public boolean isValidVerificationToken(String token) {
       VerificationToken foundVerificationToken = verificationTokenRepository.findByToken(token)
               .orElseThrow(()-> new VerificationTokenException("Token not found."));
       if (isTokenIsNoExpired(foundVerificationToken)) return true;
       throw new VerificationTokenException("Token had expired.");
    }

    private boolean isTokenIsNoExpired(VerificationToken foundVerificationToken) {
        return LocalDateTime.now().isBefore(foundVerificationToken.getExpiresAt());
    }
}
