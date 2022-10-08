package com.eCommerce.exception;
public class CustomAppException extends RuntimeException{
    public CustomAppException(String message) {
        super(message);
    }
}
