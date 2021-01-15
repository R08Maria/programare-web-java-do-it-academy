package com.example.do_it_academy.service;

import com.example.do_it_academy.exception.DuplicateLeadException;
import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.repository.LeadsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeadsService {

    private LeadsRepository repository;

    public LeadsService(LeadsRepository repository){
        this.repository = repository;
    }

    public List<Leads> getLeads(String first_name, String last_name, String phone) {
        return repository.getLeads(first_name, last_name, phone);
    }

    @Transactional
    public void saveLeads(Leads leads) {

        List<Leads> duplicateLeads = repository.getLeads(leads.getFirst_name(), leads.getLast_name(), leads.getPhone());
        if(duplicateLeads.stream().count() > 0){
            throw new DuplicateLeadException();
        }
        repository.saveLeads(leads);
    }

    @Transactional
    public void removeLeads(Integer id) {
        repository.removeLeads(id);
    }

    public List<Courses> getPreferences(Integer id_lead) {
        return repository.getPreferences(id_lead);
    }

    @Transactional
    public void addPreferences(Integer id_lead, Integer id_course){
        repository.addPreferences(id_lead, id_course);
    }

    @Transactional
    public void removePreferences(Integer id_lead, Integer id_course){
        repository.removePreferences(id_lead, id_course);
    }
}
