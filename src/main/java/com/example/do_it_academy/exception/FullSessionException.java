package com.example.do_it_academy.exception;

public class FullSessionException extends RuntimeException {

    public FullSessionException() {
        super("Session is full");
    }
}
