package com.example.do_it_academy.exception;

public class DuplicateLeadException extends RuntimeException {
    public DuplicateLeadException() {
        super("A lead with this name and phone already exists.");
    }
}
