package com.example.first_project.exception;

public class FileNotFound extends RuntimeException {
    public FileNotFound(String message) {
        super(message);
    }
}
