package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.SecurityConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationRequest;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationResponse;
import com.sysman.prueba_tecnica_sysman_backend.dto.RegisterRequest;
import com.sysman.prueba_tecnica_sysman_backend.entity.Role;
import com.sysman.prueba_tecnica_sysman_backend.entity.User;
import com.sysman.prueba_tecnica_sysman_backend.exception.RoleNotFoundException;
import com.sysman.prueba_tecnica_sysman_backend.exception.UserAlreadyExistsException;
import com.sysman.prueba_tecnica_sysman_backend.repository.RoleRepository;
import com.sysman.prueba_tecnica_sysman_backend.repository.UserRepository;
import com.sysman.prueba_tecnica_sysman_backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(ExceptionMessages.USER_ALREADY_EXISTS, request.getEmail());
        }

        Role roleUser = roleRepository.findByName(SecurityConstants.ROLE_USER)
                .orElseThrow(() -> new RoleNotFoundException(ExceptionMessages.ROLE_NOT_FOUND, SecurityConstants.ROLE_USER));

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleUser)
                .build();

        userRepository.save(user);
        log.info(LogMessages.USER_CREATED, request.getEmail());
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put(SecurityConstants.ROLE, role);

        String jwtToken = jwtService.generateToken(extraClaims, userDetails);

        log.info(LogMessages.USER_AUTHENTICATED, request.getEmail());
        return new AuthenticationResponse(jwtToken);
    }
}
