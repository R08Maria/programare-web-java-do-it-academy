package com.example.do_it_academy.exception;

public class DuplicateSessionsException extends RuntimeException {
    public DuplicateSessionsException() {
        super("A session with this name already exists.");
    }
}
