package com.margin.common.exception.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.Assert.notNull;

@Getter
public class ErrorResponseListDTO {

    private final Map<ExceptionType, List<ErrorResponseDTO>> exceptions = new HashMap<>();

    public void add(ErrorResponseDTO error) {
        notNull(error, "Error must not be null");
        notNull(error.getCode(), "Code must not be null");
        ExceptionType type = error.getCode().getType();

        List<ErrorResponseDTO> errorList = exceptions.get(type);
        if (errorList == null) {
            errorList = new ArrayList<>();
        }
        errorList.add(error);
        exceptions.put(type, errorList);
    }
}
