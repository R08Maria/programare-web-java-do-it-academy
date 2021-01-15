package com.example.do_it_academy.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class Sessions {

    private Integer id;
    private Integer id_instructor;
    private Integer id_course;
    private String name;
    private boolean live;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start_date;
    private Integer price;
    private Integer capacity;

    public Sessions(Integer id, Integer id_instructor, Integer id_course, String name, boolean live, LocalDateTime start_date, Integer price, Integer capacity) {
        this.id = id;
        this.id_instructor = id_instructor;
        this.id_course = id_course;
        this.name = name;
        this.live = live;
        this.start_date = start_date;
        this.price = price;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(Integer id_instructor) {
        this.id_instructor = id_instructor;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "id=" + id +
                ", id_instructor=" + id_instructor +
                ", id_course=" + id_course +
                ", name='" + name + '\'' +
                ", live=" + live +
                ", start_date=" + start_date +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
