package com.example.do_it_academy.controller;

import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.service.CoursesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursesController {

    private final CoursesService service;

    public CoursesController(CoursesService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    @ResponseBody
    public List<Courses> getCourses(@RequestParam(required = false) String name) {
        return service.getCourses(name);
    }

    @PutMapping("/courses")
    public void addCourses(@RequestBody Courses courses) {
        service.saveCourses(courses);
    }

    @DeleteMapping("/courses/{id}")
    public void removeCourses(@PathVariable Integer id) {
        service.removeCourses(id);
    }

}
