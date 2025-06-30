package com.sysman.prueba_tecnica_sysman_backend.security;

import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import com.sysman.prueba_tecnica_sysman_backend.entity.User;
import com.sysman.prueba_tecnica_sysman_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> {
                            log.warn(LogMessages.USER_NOT_FOUND, username);
                        return new UsernameNotFoundException(ExceptionMessages.USER_NOT_FOUND + " " + username);
                }
                );

        return ApplicationUserDetails.builder()
                .id(user.getId())
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName())))
                .build();
    }
}
