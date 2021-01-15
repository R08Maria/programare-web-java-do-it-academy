package com.example.do_it_academy.test;

import com.example.do_it_academy.exception.DuplicateCourseException;
import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.repository.CoursesRepository;
import com.example.do_it_academy.service.CoursesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursesTest {

    @Mock
    private CoursesRepository coursesRepository;

    @InjectMocks
    private CoursesService coursesService;

    @Test
    void searchForNonExistentCourse(){
        String nonExistentCourse = "javaHtmlAndPython";
        List<Courses> result = coursesService.getCourses(nonExistentCourse);
        assertTrue(result.isEmpty());
    }

    @Test
    void createCourseThrowsException() {

        Courses courses = new Courses(1,"Java", 5, "program", "");
        Courses savedCourse = new Courses(2, "Java", 5, "program", "");
        List<Courses> coursesList = new ArrayList<Courses>();
        coursesList.add(savedCourse);
        doReturn(coursesList).when(coursesRepository).getCoursesNames(any());

        DuplicateCourseException exception = assertThrows(DuplicateCourseException.class,
                () -> coursesService.saveCourses(courses));

        assertEquals("A course with this name already exists.",
                exception.getMessage());

        verify(coursesRepository).getCoursesNames(any());
        verify(coursesRepository, times(0)).saveCourses(any());
    }



//    @Test
//    void removeNonExistingCourse(){
//        int nonExistingCourseId = 10000;
//        assertThrows(RemoveCoursesException.class,() -> coursesService.removeCourses(
//                nonExistingCourseId
//        ));
//    }


}