package br.com.etrust.exceptions;

public class IncorrectMonthException extends RuntimeException {
    public IncorrectMonthException(String errorMessage) {
        super(errorMessage);
    }
}
