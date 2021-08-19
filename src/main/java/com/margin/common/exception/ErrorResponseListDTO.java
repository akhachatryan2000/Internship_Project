package com.margin.common.exception;

import com.margin.common.exception.ErrorResponseDTO;
import com.margin.common.exception.ExceptionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponseListDTO {

    private Map<ExceptionType, List<ErrorResponseDTO>> exceptions = new HashMap<>();

    public void add(ErrorResponseDTO error) {
        //TODO TO ADD EXCEPTION HANDLERS
        
    }
}
