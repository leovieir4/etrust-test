package br.com.etrust.exceptions;

public class IncorrectDaysException extends RuntimeException {
    public IncorrectDaysException (String errorMessage) {
        super(errorMessage);
    }
}
