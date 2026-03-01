package com.businesssearch.advice;

import com.businesssearch.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ProblemDetail.forStatusAndDetail;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public ProblemDetail handleException(BadRequestException ex) {
        return forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
