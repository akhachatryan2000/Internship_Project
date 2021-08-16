package com.margin.common.exception;

public class ErrorResponseDTO {

    private String message;

    private ExceptionType code;

    public ErrorResponseDTO(String message, ExceptionType code) {
        this.message = message;
        this.code = code;
    }
}
