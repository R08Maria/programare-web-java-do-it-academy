package com.example.do_it_academy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Leads {
    private Integer id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contact_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birth_date;
    private String conversation_summary;

    public Leads(Integer id, String last_name, String first_name, String phone, String email, LocalDateTime contact_date, LocalDateTime birth_date, String conversation_summary) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
        this.email = email;
        this.contact_date = contact_date;
        this.birth_date = birth_date;
        this.conversation_summary = conversation_summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getContact_date() {
        return contact_date;
    }

    public void setContact_date(LocalDateTime contact_date) {
        this.contact_date = contact_date;
    }

    public LocalDateTime getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDateTime birth_date) {
        this.birth_date = birth_date;
    }

    public String getConversation_summary() {
        return conversation_summary;
    }

    public void setConversation_summary(String conversation_summary) {
        this.conversation_summary = conversation_summary;
    }
}
