package com.example.do_it_academy.controller;

import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.model.Sessions;
import com.example.do_it_academy.service.SessionsService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SessionsController {

    private final SessionsService service;

    public SessionsController(SessionsService sessionsService) {
        this.service = sessionsService;
    }

    @GetMapping("/sessions")
    @ResponseBody
    public List<Sessions> getSessions(@RequestParam(required = false) LocalDateTime start_date) {
        return service.getSessions(start_date);
    }

    @PutMapping("/sessions")
    public void scheduleSessions(@RequestBody Sessions sessions) {
        service.saveSessions(sessions);
    }

    @DeleteMapping("/sessions/{id}")
    public void removeSessions(@PathVariable Integer id) {
        service.removeSessions(id);
    }

    @GetMapping("sessions/{id_session}/learners")
    public List<Leads> getLearners(@PathVariable Integer id_session) {
        return service.getLearners(id_session);

    }

    @PutMapping("sessions/{id_session}/learners")
    public void saveLearners(@PathVariable Integer id_session, @RequestBody Integer learners) {
        service.saveLearners(id_session, learners);
    }

    @DeleteMapping("/sessions/{id_session}/{id_lead}")
    public void removeLearners(@PathVariable Integer id_session, @PathVariable Integer id_lead) {
        service.removeLearners(id_session, id_lead);
    }
}
