package com.margin.controller.product.exception;

import com.margin.common.exception.response.ExceptionCode;
import com.margin.common.exception.response.ExceptionType;

public class ProductDosntExistException extends RuntimeException {

    private String message;

    private ExceptionCode code;


}
