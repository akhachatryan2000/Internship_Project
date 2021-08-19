package com.margin.common;

import com.margin.common.exception.ErrorResponseListDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GenericResponseDTO <T>{

    private T body;

    private List<ErrorResponseListDTO> errorResponseDTOS;
}
