package com.margin.common.exception.order;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderNotValidException extends DomainNotValidException {

    private String message;

    private ExceptionCode code;

    public OrderNotValidException(String message, ExceptionCode code) {
        super(message,code);
        this.message = message;
        this.code = code;
    }
}
