package com.example.do_it_academy.exception;

public class RemoveInstructorsException extends RuntimeException {

    public RemoveInstructorsException() {
        super("You can't remove this instructor");
    }
}
