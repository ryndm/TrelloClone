package com.example.ood_project.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Resource not found!!");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
