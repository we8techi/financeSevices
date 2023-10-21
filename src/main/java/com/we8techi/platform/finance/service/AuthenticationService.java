package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.objects.AuthenticationRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    String authenticate(AuthenticationRequest authenticationRequest);
}
