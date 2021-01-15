package com.example.do_it_academy.controller;

import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.service.LeadsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeadsController {

    private final LeadsService service;

    public LeadsController(LeadsService leadsService) {
        this.service = leadsService;
    }

    @GetMapping("/leads")
    @ResponseBody
    public List<Leads> getInstructors(@RequestParam(required = false) String first_name, @RequestParam(required = false) String last_name, @RequestParam(required = false) String phone) {
        return service.getLeads(first_name, last_name, phone);
    }

    @PutMapping("/leads")
    public void addInstructors(@RequestBody Leads leads) {
        service.saveLeads(leads);
    }

    @DeleteMapping("/leads/{id}")
    public void removeInstructors(@PathVariable Integer id) {
        service.removeLeads(id);
    }

    @GetMapping("leads/{id_lead}/preferences")
    public List<Courses> getPreferences(@PathVariable Integer id_lead) {
        return service.getPreferences(id_lead);

    }

    @PutMapping("leads/{id_lead}/preferences")
    public void addPreferences(@PathVariable Integer id_lead, @RequestBody Integer preferences) {
        service.addPreferences(id_lead, preferences);
    }

    @DeleteMapping("leads/{id_lead}/preferences")
    public void removePreferences(@PathVariable Integer id_lead, @PathVariable Integer id_course) {
        service.removePreferences(id_lead, id_course);
    }


}
