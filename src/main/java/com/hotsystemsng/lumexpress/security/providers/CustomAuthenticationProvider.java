package com.hotsystemsng.lumexpress.security.providers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final CachingUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        if (userDetails != null) {
            if (passwordEncoder.matches((String) authentication.getCredentials(), userDetails.getPassword())) {
                var authenticatedToken =
                        new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                                authentication.getCredentials(),
                                userDetails.getAuthorities());
                return authenticatedToken;
            }
            throw new BadCredentialsException("Invalid Credentials!");
        }
        throw new AuthenticationCredentialsNotFoundException("Email does not exist!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        var appAuth = UsernamePasswordAuthenticationToken.class;
        return authentication.equals(appAuth);
    }
}
