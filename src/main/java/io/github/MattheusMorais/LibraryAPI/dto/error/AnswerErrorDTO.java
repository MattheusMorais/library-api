package io.github.MattheusMorais.LibraryAPI.dto.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public record AnswerErrorDTO(
        int status,
        String message,
        List<FieldErrorDTO> errors
) {

    public static AnswerErrorDTO standardAnswer(String message) {
        return new AnswerErrorDTO(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static AnswerErrorDTO conflictAnswer(String message) {
        return new AnswerErrorDTO(HttpStatus.CONFLICT.value(), message, List.of());
    }


}
