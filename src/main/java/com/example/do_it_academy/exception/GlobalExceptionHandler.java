package com.example.do_it_academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({SQLException.class, DuplicateSessionsException.class, RemoveSessionsException.class,
            SessionsInSameTimeException.class, FullSessionException.class,
             CourseNotFound.class, DuplicateCourseException.class, RemoveCoursesException.class,
            DuplicateInstructorsException.class, RemoveInstructorsException.class,
            DuplicateLeadException.class, RemoveLeadsException.class,
            AddLearnersException.class, DuplicateLearnerException.class, RemoveLearnersException.class
    })
    public final ResponseEntity<String> handleOtherExceptions(Exception exception, WebRequest request) {
        return new ResponseEntity<String>("Exception was: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
