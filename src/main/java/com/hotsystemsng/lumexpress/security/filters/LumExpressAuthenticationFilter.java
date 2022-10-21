package com.hotsystemsng.lumexpress.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotsystemsng.lumexpress.data.models.LumExpressUser;
import com.hotsystemsng.lumexpress.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class LumExpressAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            LumExpressUser user = mapper.readValue(request.getInputStream(), LumExpressUser.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        log.info("email -> {}, password -> {}", email, password);

        var authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticatedToken = customAuthenticationManager.authenticate(authenticationToken);
        if (authenticatedToken != null) {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticatedToken);
            return authenticatedToken;
        }
        throw new BadCredentialsException("Bad Credentials!");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    }
}
