package com.example.do_it_academy.exception;

public class DuplicateLearnerException extends RuntimeException {

    public DuplicateLearnerException() {
        super("Error duplicated learner.");
    }
}
