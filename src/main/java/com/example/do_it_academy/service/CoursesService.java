package com.example.do_it_academy.service;

import com.example.do_it_academy.exception.DuplicateCourseException;
import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.repository.CoursesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CoursesService {

    private CoursesRepository repository;

    public CoursesService(CoursesRepository repository){
        this.repository = repository;
    }

    public List<Courses> getCourses(String name) {
        return repository.getCoursesNames(name);
    }

    @Transactional
    public void saveCourses(Courses courses) {
       List<Courses> coursesWithSameName = repository.getCoursesNames(courses.getName());
        if(coursesWithSameName.stream().count() > 0) {
            throw new DuplicateCourseException();
        }
        repository.saveCourses(courses);
    }

    @Transactional
    public void removeCourses(Integer id) {
        repository.removeCourses(id);
    }

}
