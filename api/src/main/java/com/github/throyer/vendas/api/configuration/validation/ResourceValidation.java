package com.github.throyer.vendas.api.configuration.validation;

import java.util.List;
import java.util.stream.Collectors;

import com.github.throyer.vendas.api.domain.models.shared.Error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceValidation {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Error> badRequest(MethodArgumentNotValidException exception) {

        return exception.getBindingResult()
            .getAllErrors()
                .stream()
                    .map(erro -> new Error((FieldError) erro))
                        .collect(Collectors.toList());
    }

}