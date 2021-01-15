package com.example.do_it_academy.test;

import com.example.do_it_academy.exception.DuplicateInstructorsException;
import com.example.do_it_academy.model.Instructors;
import com.example.do_it_academy.repository.InstructorsRepository;
import com.example.do_it_academy.service.InstructorsService;
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
class InstructorsTest {

    @Mock
    private InstructorsRepository instructorsRepository;

    @InjectMocks
    private InstructorsService instructorsService;

    @Test
    void searchForNonExistentIn(){
        List<Instructors> result = instructorsService.getInstructors("first_name","last_name","phone");
        assertTrue(result.isEmpty());
    }

    @Test
    void createInstructorThrowsException() {

        Instructors instructors = new Instructors(1,"Dan", "Stefanescu", "0758965410", "dan.s@yahoo.com");
        Instructors savedInstructor = new Instructors(2, "Dan", "Stefanescu", "0758965410", "dan.s@yahoo.com");
        List<Instructors> instructorsList = new ArrayList<Instructors>();
        instructorsList.add(savedInstructor);
        doReturn(instructorsList).when(instructorsRepository).getInstructors(any(), any(), any());

        DuplicateInstructorsException exception = assertThrows(DuplicateInstructorsException.class,
                () -> instructorsService.saveInstructors(instructors));

        assertEquals("A instructor with this name already exists.",
                exception.getMessage());

        verify(instructorsRepository).getInstructors(any(), any(), any());
        verify(instructorsRepository, times(0)).saveInstructors(any());
    }

//    @Test
//    void removeNonExistingInstructor(){
//        int nonExistingInstructorId = 10000;
//        assertThrows(RemoveInstructorsException.class,() -> instructorsService.removeInstructors(
//                nonExistingInstructorId
//        ));
//    }


}