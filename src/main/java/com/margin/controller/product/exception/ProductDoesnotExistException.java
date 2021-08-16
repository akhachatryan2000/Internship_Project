package com.margin.controller.product.exception;

import com.margin.common.exception.ExceptionType;

public class ProductDoesnotExistException extends RuntimeException{

    private String message;

    private ExceptionType code;


}
