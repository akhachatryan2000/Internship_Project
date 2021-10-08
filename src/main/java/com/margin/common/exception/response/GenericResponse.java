package com.margin.common.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class GenericResponse<T> {

    private T body;

    private ErrorResponseListDTO errorResponse;
}
