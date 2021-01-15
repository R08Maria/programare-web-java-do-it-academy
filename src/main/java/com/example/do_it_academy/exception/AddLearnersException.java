package com.example.do_it_academy.exception;

public class AddLearnersException extends RuntimeException {

    public AddLearnersException() {
        super("Error inserting learner.");
    }
}
