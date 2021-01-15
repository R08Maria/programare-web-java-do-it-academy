package com.example.do_it_academy.controller;

import com.example.do_it_academy.service.LearnersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/learners")
public class LearnersController {

    private final LearnersService learnersService;

    public LearnersController(LearnersService learnersService) {
        this.learnersService = learnersService;
    }
}
