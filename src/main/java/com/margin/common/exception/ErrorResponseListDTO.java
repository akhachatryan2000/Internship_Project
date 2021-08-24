package com.margin.common.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponseListDTO {

    private Map<ExceptionType, List<ErrorResponseDTO>> exceptions = new HashMap<>();

    public void add(ErrorResponseDTO error) {
    }
}
