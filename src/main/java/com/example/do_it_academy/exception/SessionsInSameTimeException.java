package com.example.do_it_academy.exception;

public class SessionsInSameTimeException extends RuntimeException {
    public SessionsInSameTimeException() {
        super("A session is already schedule in the same time.");
    }
}
