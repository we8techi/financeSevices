package com.we8techi.platform.finance.objects;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {

    private String message;
    private HttpStatus status;
    private boolean success;

    public APIResponse(String message, HttpStatus httpStatus) {
    }

    public APIResponse(boolean success, HttpStatus httpStatus) {
    }
}
