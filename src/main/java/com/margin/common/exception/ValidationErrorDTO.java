package com.margin.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ValidationErrorDTO {

    private String field;

    private String message;
}
