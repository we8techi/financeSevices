package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.objects.AuthenticationRequest;
import com.we8techi.platform.finance.objects.AuthenticationResponse;
import com.we8techi.platform.finance.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {

        String result = authenticationService.authenticate(authenticationRequest);

        if (null != result) {
            return new ResponseEntity<>(AuthenticationResponse.builder().jwt(result).build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(
                APIResponse.builder()
                        .message("Invalid credentials...!!!")
                        .status(HttpStatus.BAD_REQUEST)
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
