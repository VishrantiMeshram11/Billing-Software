package com.billing.billing_software.exception;

public class InsufficentStockException extends RuntimeException {
    public InsufficentStockException(String message) {
        super(message);
    }
}
