package com.example.do_it_academy.exception;

public class RemoveCoursesException extends RuntimeException {

    public RemoveCoursesException() {
        super("You can't delete this course because it doesn't exist");
    }
}
