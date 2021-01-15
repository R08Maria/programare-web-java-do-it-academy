package com.example.do_it_academy.service;

import com.example.do_it_academy.exception.DuplicateInstructorsException;
import com.example.do_it_academy.model.Instructors;
import com.example.do_it_academy.repository.InstructorsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorsService {

    private InstructorsRepository repository;

    public InstructorsService(InstructorsRepository repository){
        this.repository = repository;
    }

    public List<Instructors> getInstructors(String first_name, String last_name, String phone) {
        return repository.getInstructors(first_name, last_name, phone);
    }

    @Transactional
    public void saveInstructors(Instructors instructors) {
        List<Instructors> duplicateInstructors = repository.getInstructors(instructors.getFirst_name(), instructors.getLast_name(), instructors.getPhone());
        if(duplicateInstructors.stream().count() > 0){
            throw new DuplicateInstructorsException();
        }

        repository.saveInstructors(instructors);
    }

    @Transactional
    public void removeInstructors(Integer id) {
        repository.removeInstructors(id);
    }
}
