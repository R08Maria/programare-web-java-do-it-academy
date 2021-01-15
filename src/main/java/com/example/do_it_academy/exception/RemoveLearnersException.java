package com.example.do_it_academy.exception;

public class RemoveLearnersException extends RuntimeException {

    public RemoveLearnersException() {
        super("This learner doesn't exist");
    }
}
