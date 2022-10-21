package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.LoginResponse;
import com.hotsystemsng.lumexpress.data.models.LumExpressUser;

public interface UserService {
    LoginResponse login(LoginRequest request);
    LumExpressUser getUserByUsername(String email);
}
