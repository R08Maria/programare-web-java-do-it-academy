package com.example.do_it_academy.model;


public class Learners {
    private Integer id;
    private Integer id_session;
    private Integer id_lead;

    public Learners(Integer id, Integer id_session, Integer id_lead) {
        this.id = id;
        this.id_session = id_session;
        this.id_lead = id_lead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_session() {
        return id_session;
    }

    public void setId_session(Integer id_session) {
        this.id_session = id_session;
    }

    public Integer getId_lead() {
        return id_lead;
    }

    public void setId_lead(Integer id_lead) {
        this.id_lead = id_lead;
    }

}
