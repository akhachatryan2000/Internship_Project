package com.margin.common.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ErrorResponseDTO {

    private String message;

    private ExceptionCode code;

    public ErrorResponseDTO(String message, ExceptionCode code) {
        this.message = message;
        this.code = code;
    }
}
