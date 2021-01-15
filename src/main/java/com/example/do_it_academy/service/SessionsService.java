package com.example.do_it_academy.service;

import com.example.do_it_academy.exception.SessionsInSameTimeException;
import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.model.Sessions;
import com.example.do_it_academy.repository.SessionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionsService {
    private SessionsRepository repository;

    public SessionsService(SessionsRepository repository) {
        this.repository = repository;

    }

    public List<Sessions> getSessions(LocalDateTime start_date) {
        return repository.getSessions(start_date);
    }

    @Transactional
    public void saveSessions(Sessions sessions) {
        List<Sessions> sessionsInSameTime = repository.getSessions(sessions.getStart_date());
        if(sessionsInSameTime.stream().count() > 0){
            throw new SessionsInSameTimeException();
        }
        repository.saveSessions(sessions);
    }

    @Transactional
    public void removeSessions(Integer id) {
        repository.removeSessions(id);
    }


    public List<Leads> getLearners(Integer id_session) {
        return repository.getLearners(id_session);
    }

    @Transactional
    public void saveLearners(Integer id_session, Integer learners) {
        repository.addLearners(id_session, learners);
    }


    @Transactional
    public void removeLearners(Integer id_session, Integer id_lead) {
        repository.removeLearners(id_session, id_lead);
    }

}
