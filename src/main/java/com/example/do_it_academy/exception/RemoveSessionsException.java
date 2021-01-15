package com.example.do_it_academy.exception;

public class RemoveSessionsException extends RuntimeException {

    public RemoveSessionsException() {
        super("You can't remove this sessions");
    }
}
