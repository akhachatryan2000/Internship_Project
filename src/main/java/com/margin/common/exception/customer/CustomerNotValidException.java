package com.margin.common.exception.customer;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerNotValidException extends DomainNotValidException {

    private String message;

    private ExceptionCode code;

    public CustomerNotValidException(String message, ExceptionCode code) {
        super(message, code);
        this.message = message;
        this.code = code;
    }
}
