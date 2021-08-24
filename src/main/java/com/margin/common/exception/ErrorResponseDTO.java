package com.margin.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponseDTO {

    private String message;

    private ExceptionType code;

    public ErrorResponseDTO(String message, ExceptionType code) {
        this.message = message;
        this.code = code;
    }
}
