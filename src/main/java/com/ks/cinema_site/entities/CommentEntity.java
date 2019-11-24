package com.ks.cinema_site.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cinema_id;
    @ManyToOne
    private UserEntity usr;
    private String comment;
    private Date date;

    public CommentEntity() {
    }

    public CommentEntity(Long cinema_id, UserEntity user, String comment, Date date) {
        this.id = id;
        this.cinema_id = cinema_id;
        this.usr = user;
        this.comment = comment;
        this.date = date;
    }

    public CommentEntity(Long id, Long cinema_id, UserEntity user, String comment, Date date) {
        this.id = id;
        this.cinema_id = cinema_id;
        this.usr = user;
        this.comment = comment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(Long cinema_id) {
        this.cinema_id = cinema_id;
    }

    public UserEntity getUsr() {
        return usr;
    }

    public void setUsr(UserEntity usr) {
        this.usr = usr;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
