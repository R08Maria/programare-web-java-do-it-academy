package com.example.do_it_academy.test;

import com.example.do_it_academy.exception.SessionsInSameTimeException;
import com.example.do_it_academy.model.Sessions;
import com.example.do_it_academy.repository.SessionsRepository;
import com.example.do_it_academy.service.SessionsService;
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
public class SessionsTests {
    @Mock
    private SessionsRepository sessionsRepository;
    @InjectMocks
    private SessionsService sessionsService;

    @Test
    void searchForNonExistentSession(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nonExistentSession = LocalDateTime.parse("2021-05-05 02:02:02",formatter);
        List<Sessions> result = sessionsService.getSessions(nonExistentSession);
        assertTrue(result.isEmpty());
    }

    @Test
    void createSessionThrowsException() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Sessions sessions = new Sessions(1,1,1,"", true, LocalDateTime.parse("2020-05-05 02:02:02",formatter), 300, 50);
        Sessions savedSessions = new Sessions(2,2,2,"", true, LocalDateTime.parse("2020-05-05 02:02:02",formatter), 300, 50);
        List<Sessions> sessionsList = new ArrayList<Sessions>();
        sessionsList.add(savedSessions);
        doReturn(sessionsList).when(sessionsRepository).getSessions(any());

        SessionsInSameTimeException exception = assertThrows(SessionsInSameTimeException.class,
                () -> sessionsService.saveSessions(sessions));

        assertEquals("A session is already schedule in the same time.",
                exception.getMessage());

        verify(sessionsRepository).getSessions(any());
        verify(sessionsRepository, times(0)).saveSessions(any());
    }


}