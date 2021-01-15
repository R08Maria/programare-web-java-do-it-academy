package com.example.do_it_academy.exception;

public class CourseNotFound extends RuntimeException {
    public CourseNotFound() {
        super("Error this course doesn't exist.");
    }
}
