package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.VerificationToken;

public interface VerificationTokenService {
    VerificationToken generateVerificationToken(String userEmail);
}
