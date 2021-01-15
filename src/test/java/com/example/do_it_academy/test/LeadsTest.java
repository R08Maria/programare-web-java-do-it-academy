package com.example.do_it_academy.test;

import com.example.do_it_academy.exception.DuplicateLeadException;
import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.repository.LeadsRepository;
import com.example.do_it_academy.service.LeadsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeadsTest {

    @Mock
    private LeadsRepository leadsRepository;

    @InjectMocks
    private LeadsService leadsService;

    @Test
    void searchForNonExistentLead(){
        List<Leads> result = leadsService.getLeads(any(), any(), any());
        assertTrue(result.isEmpty());
    }

    @Test
    void createLeadThrowsException() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Leads leads = new Leads(1,"Ana", "Iordache","0732564125", "ana.iordache@gmail.com", LocalDateTime.parse("2021-05-05 02:02:02",formatter), LocalDateTime.parse("2000-05-05 02:02:02",formatter), "conversation");
        Leads savedLead = new Leads(2,"Ana", "Iordache","0732564125", "ana.iordache@gmail.com", LocalDateTime.parse("2021-05-05 02:02:02",formatter), LocalDateTime.parse("2000-05-05 02:02:02",formatter), "conversation");
        List<Leads> leadsList = new ArrayList<Leads>();
        leadsList.add(savedLead);
        doReturn(leadsList).when(leadsRepository).getLeads(any(), any(), any());

        DuplicateLeadException exception = assertThrows(DuplicateLeadException.class,
                () -> leadsService.saveLeads(leads));

        assertEquals("A lead with this name and phone already exists.",
                exception.getMessage());

        verify(leadsRepository).getLeads(any(), any(), any());
        verify(leadsRepository, times(0)).saveLeads(any());
    }

}