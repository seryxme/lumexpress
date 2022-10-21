package com.hotsystemsng.lumexpress.security;

import com.hotsystemsng.lumexpress.data.models.LumExpressUser;
import com.hotsystemsng.lumexpress.exceptions.UserNotFoundException;
import com.hotsystemsng.lumexpress.services.notification.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        LumExpressUser user = null;
        try {
            user = userService.getUserByUsername(username);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new SecureUser(user);
    }
}
