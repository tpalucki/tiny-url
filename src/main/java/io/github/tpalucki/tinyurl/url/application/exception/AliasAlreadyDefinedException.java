package io.github.tpalucki.tinyurl.url.application.exception;


public class AliasAlreadyDefinedException extends RuntimeException {

    public AliasAlreadyDefinedException(String message) {
        super(message);
    }
}
