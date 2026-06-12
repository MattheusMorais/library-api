package io.github.MattheusMorais.LibraryAPI.exceptions;

public class DuplicateRegisterException extends RuntimeException {
    public DuplicateRegisterException(String message) {
        super(message);
    }
}
