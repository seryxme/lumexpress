package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest request);
}
