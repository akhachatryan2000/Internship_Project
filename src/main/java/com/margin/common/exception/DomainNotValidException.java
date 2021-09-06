package com.margin.common.exception;

import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainNotValidException extends RuntimeException {

    private ExceptionCode code;

    private String message;

    public DomainNotValidException(String message, ExceptionCode code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
