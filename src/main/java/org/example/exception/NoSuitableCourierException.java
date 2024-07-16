package org.example.exception;

public class NoSuitableCourierException extends RuntimeException{
    public NoSuitableCourierException(Integer orderId) {
        super("No suitable courier found for order " + orderId);
    }
}