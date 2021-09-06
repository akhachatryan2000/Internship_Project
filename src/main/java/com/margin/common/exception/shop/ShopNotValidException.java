package com.margin.common.exception.shop;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopNotValidException extends DomainNotValidException {

    private String message;

    private ExceptionCode code;

    public ShopNotValidException(String message, ExceptionCode code) {
        super(message,code);
        this.code = code;
        this.message = message;
    }
}
