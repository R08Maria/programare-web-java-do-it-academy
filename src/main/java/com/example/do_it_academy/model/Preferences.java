package com.example.do_it_academy.model;

public class Preferences {
    private Integer id;
    private Integer id_course;
    private Integer id_lead;


    public Preferences(Integer id_course, Integer id_lead) {
        this.id_course = id_course;
        this.id_lead = id_lead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public Integer getId_lead() {
        return id_lead;
    }

    public void setId_lead(Integer id_lead) {
        this.id_lead = id_lead;
    }

}
