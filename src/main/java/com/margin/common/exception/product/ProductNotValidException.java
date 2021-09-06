package com.margin.common.exception.product;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotValidException extends DomainNotValidException {

    private ExceptionCode code;

    private String message;

    public ProductNotValidException(String message, ExceptionCode code) {
        super(message, code);
        this.code = code;
        this.message = message;
    }
}
