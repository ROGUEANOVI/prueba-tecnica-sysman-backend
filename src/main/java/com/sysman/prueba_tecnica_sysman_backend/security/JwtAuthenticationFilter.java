package com.sysman.prueba_tecnica_sysman_backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.SecurityConstants;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String token;
        final String username;

        if (authHeader == null || !authHeader.startsWith(SecurityConstants.BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);

        try {
            username = jwtService.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtService.isTokenValid(token, userDetails)) {
                    var authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }catch (ExpiredJwtException ex) {
            log.warn(LogMessages.INVALID_TOKEN, ex.getMessage());
            handleJwtException(response, ExceptionMessages.EXPIRED_TOKEN);
            return;
        } catch (MalformedJwtException | SignatureException | IllegalArgumentException ex) {
            log.warn(LogMessages.TOKEN_EXPIRED, ex.getMessage());
            handleJwtException(response, ExceptionMessages.INVALID_TOKEN);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void handleJwtException(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write(
                new ObjectMapper().writeValueAsString(Collections.singletonMap(ExceptionMessages.MESSAGE, message))
        );
    }
}
