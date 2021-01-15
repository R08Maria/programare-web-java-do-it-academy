package com.example.do_it_academy.exception;

public class DuplicateInstructorsException extends RuntimeException {
    public DuplicateInstructorsException() {
        super("A instructor with this name and phone already exists.");
    }
}
