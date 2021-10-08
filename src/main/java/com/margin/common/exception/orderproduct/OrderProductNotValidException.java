package com.margin.common.exception.orderproduct;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductNotValidException extends DomainNotValidException {

    private String message;

    private ExceptionCode code;

    public OrderProductNotValidException(String message, ExceptionCode code) {
        super(message, code);
        this.message = message;
        this.code = code;
    }
}
