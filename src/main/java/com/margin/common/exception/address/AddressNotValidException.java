package com.margin.common.exception.address;


import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressNotValidException extends DomainNotValidException {

    private String message;

    private ExceptionCode exceptionCode;

    public AddressNotValidException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
        this.message = message;
        this.exceptionCode = exceptionCode;
    }
}
