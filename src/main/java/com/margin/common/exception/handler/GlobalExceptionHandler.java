package com.margin.common.exception.handler;

import com.margin.common.exception.DomainNotValidException;
import com.margin.common.exception.response.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public GenericResponse<Object> handleDomainNotValidException(DomainNotValidException exception) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        String message = exception.getMessage();
        ExceptionCode code = exception.getCode();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(message, code);
        errorResponses.add(errorResponseDTO);
        return new GenericResponse<>(null, errorResponses);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(exception.getMessage(), ExceptionCode.UUTI_45);
        errorResponses.add(errorResponse);
        return new GenericResponse<>(null, errorResponses);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage(), ExceptionCode.UUTI_45);
        errorResponses.add(errorResponse);
        return new GenericResponse<>(null, errorResponses);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericResponse<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage(), ExceptionCode.UUTI_45);
        errorResponses.add(errorResponse);
        return new GenericResponse<>(null, errorResponses);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errorResponses.add(new ErrorResponseDTO(error.getDefaultMessage(), ExceptionCode.UUTI_45));
        }
        return new GenericResponse<>(null, errorResponses);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception) {
        ErrorResponseListDTO errorResponses = new ErrorResponseListDTO();
        List<String> details = new ArrayList<>();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            details.add(cv.getMessage());
        }
        ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper(exception.getMessage(), details);
        return new ResponseEntity<>(errorResponseWrapper, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericResponse<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        ErrorResponseListDTO errorResponseListDTO = new ErrorResponseListDTO();
        String message = exception.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(message, ExceptionCode.UUTI_45);
        errorResponseListDTO.add(errorResponseDTO);
        return new GenericResponse<>(null, errorResponseListDTO);
    }
}
