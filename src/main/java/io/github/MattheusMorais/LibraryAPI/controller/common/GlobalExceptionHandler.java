package io.github.MattheusMorais.LibraryAPI.controller.common;

import io.github.MattheusMorais.LibraryAPI.dto.error.AnswerErrorDTO;
import io.github.MattheusMorais.LibraryAPI.dto.error.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public AnswerErrorDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldErrorDTO> errors = e.getFieldErrors()
                .stream()
                .map(fieldError -> new FieldErrorDTO(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .toList();

        return new AnswerErrorDTO(
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Erro de validação",
                errors
        );
    }
}
