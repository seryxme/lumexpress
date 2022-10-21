package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import com.hotsystemsng.lumexpress.exceptions.VerificationTokenException;

public interface VerificationTokenService {
    VerificationToken createToken(String userEmail);
    boolean isValidVerificationToken(String token) throws VerificationTokenException;
}
