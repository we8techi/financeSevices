package com.we8techi.platform.finance.exception.handler;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(){
        super("Resource not found");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}

