package com.we8techi.platform.finance.exception.handler;

import com.we8techi.platform.finance.objects.APIResponse;
import com.we8techi.platform.finance.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class FinanceExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAdminMasterServiceException(Exception ex) {
        log.error("Exception occurred: " + ex.getMessage());
        return new ResponseEntity<>(new APIResponse(Constants.SERVER_ERROR, HttpStatus.BAD_REQUEST), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(), HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }

}
