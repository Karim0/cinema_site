package com.ks.cinema_site.entities;


import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    private Long id;
    private String nameCinema;
    private String time;
    private String format;
    private String language;
    private Integer costForAdult;
    private Integer costForChild;
    private Integer costForStudent;
    private Integer costForVIP;

    @JoinColumn(name = "movie_id")
    private Long movie;

    public Schedule() {
    }

    public Schedule(Long id, String nameCinema, String time,
                    String format, String language,
                    Integer costForAdult, Integer costForChild,
                    Integer costForStudent, Integer costForVIP) {
        this.id = id;
        this.nameCinema = nameCinema;
        this.time = time;
        this.format = format;
        this.language = language;
        this.costForAdult = costForAdult;
        this.costForChild = costForChild;
        this.costForStudent = costForStudent;
        this.costForVIP = costForVIP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCinema() {
        return nameCinema;
    }

    public void setNameCinema(String nameCinema) {
        this.nameCinema = nameCinema;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getCostForAdult() {
        return costForAdult;
    }

    public void setCostForAdult(Integer costForAdult) {
        this.costForAdult = costForAdult;
    }

    public Integer getCostForChild() {
        return costForChild;
    }

    public void setCostForChild(Integer costForChild) {
        this.costForChild = costForChild;
    }

    public Integer getCostForStudent() {
        return costForStudent;
    }

    public void setCostForStudent(Integer costForStudent) {
        this.costForStudent = costForStudent;
    }

    public Integer getCostForVIP() {
        return costForVIP;
    }

    public void setCostForVIP(Integer costForVIP) {
        this.costForVIP = costForVIP;
    }

    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }
}
