package com.ucx.training.demo.repository;

public class DuplicateFoundException extends Exception {
    public DuplicateFoundException(String message) {
        super(message);
    }
}
