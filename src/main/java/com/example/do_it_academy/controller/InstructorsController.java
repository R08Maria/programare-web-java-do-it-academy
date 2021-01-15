package com.example.do_it_academy.controller;

import com.example.do_it_academy.model.Instructors;
import com.example.do_it_academy.service.InstructorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorsController {

    private final InstructorsService service;

    public InstructorsController(InstructorsService instructorsService) {
        this.service = instructorsService;
    }

    @GetMapping("/instructors")
    @ResponseBody
    public List<Instructors> getInstructors(@RequestParam(required = false) String first_name, @RequestParam(required = false) String last_name, @RequestParam(required = false) String phone) {
        return service.getInstructors(first_name, last_name, phone);
    }

    @PutMapping("/instructors")
    public void addInstructors(@RequestBody Instructors instructors) {
        service.saveInstructors(instructors);
    }

    @DeleteMapping("/instructors/{id}")
    public void removeInstructors(@PathVariable Integer id) {
        service.removeInstructors(id);
    }
}
