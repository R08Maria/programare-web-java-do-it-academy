package com.example.do_it_academy.model;

public class Courses {
    private Integer id;
    private String name;
    private Integer duration;
    private String program;
    private String description;

    public Courses(Integer id, String name, Integer duration, String program, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.program = program;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
