package com.we8techi.platform.finance.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationException extends RuntimeException {

    private String message;
    private HttpStatus status;
}
