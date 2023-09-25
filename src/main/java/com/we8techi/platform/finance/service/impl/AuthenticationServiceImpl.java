package com.we8techi.platform.finance.service.impl;

import com.we8techi.platform.finance.config.MyUserDetails;
import com.we8techi.platform.finance.objects.AuthenticationRequest;
import com.we8techi.platform.finance.service.AuthenticationService;
import com.we8techi.platform.finance.service.MyUserDetailsService;
import com.we8techi.platform.finance.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationProvider
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
            MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

            return jwtUtil.generateToken(userDetails);
        } catch (Exception ex) {
            log.error("Bad credentials...!!! message ={}", ex.getMessage());
        }
        return null;
    }
}
