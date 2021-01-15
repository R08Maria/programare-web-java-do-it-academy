package com.example.do_it_academy.exception;

public class DuplicateCourseException extends RuntimeException {
    public DuplicateCourseException() {
        super("A course with this name already exists.");
    }
}
