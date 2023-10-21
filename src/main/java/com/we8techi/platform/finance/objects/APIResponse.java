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
}
