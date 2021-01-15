package com.example.do_it_academy.exception;

public class RemoveLeadsException extends RuntimeException {

    public RemoveLeadsException() {
        super("You can't delete this lead because it doesn't exist");
    }
}
