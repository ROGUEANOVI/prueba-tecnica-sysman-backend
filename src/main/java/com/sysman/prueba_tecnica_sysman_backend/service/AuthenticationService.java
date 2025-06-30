package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationRequest;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationResponse;
import com.sysman.prueba_tecnica_sysman_backend.dto.RegisterRequest;

public interface AuthenticationService {

    void register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
