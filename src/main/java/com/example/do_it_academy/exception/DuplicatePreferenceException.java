package com.example.do_it_academy.exception;

public class DuplicatePreferenceException extends RuntimeException {
    public DuplicatePreferenceException() {
        super("A lead with this preference already exists.");
    }
}
