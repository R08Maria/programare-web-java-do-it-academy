package com.example.do_it_academy.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PreferencesRepository {

    private final JdbcTemplate jdbcTemplate;

    public PreferencesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
