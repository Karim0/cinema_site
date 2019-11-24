package com.ks.cinema_site.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class MoviesEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private Date realise;

    @ElementCollection
    private Set<String> authors;

    @ElementCollection
    private Set<String> actors;
    private Double rating;
    private int amountRating;

    private String country;
    private String photoPath;
    private String videoPath;
    private Integer dur;

    @ElementCollection(targetClass = AgeRating.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "age_rating", joinColumns = @JoinColumn(name = "movie_id"))
    @Enumerated(EnumType.STRING)
    private Set<AgeRating> ageRating;

//    @ElementCollection(targetClass = CategoryEntity.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "category", joinColumns = @JoinColumn(name = "category_id"))
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = CategoryEntity.class)
    private Set<CategoryEntity> category;

//    @OneToMany
//    private Set<Schedule> schedules;

    public MoviesEntity() {
    }

    public MoviesEntity(Long id, String title, String description,
                        Set<String> authors, Set<String> actors,
                        Double rating, int amountRating, String country, String photoPath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.actors = actors;
        this.rating = rating;
        this.amountRating = amountRating;
        this.country = country;
        this.photoPath = photoPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getAmountRating() {
        return amountRating;
    }

    public void setAmountRating(int amountRating) {
        this.amountRating = amountRating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<AgeRating> getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(Set<AgeRating> ageRating) {
        this.ageRating = ageRating;
    }

    public Set<CategoryEntity> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryEntity> category) {
        this.category = category;
    }

//    public Set<Schedule> getSchedules() {
//        return schedules;
//    }
//
//    public void setSchedules(Set<Schedule> schedules) {
//        this.schedules = schedules;
//    }


    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Date getRealise() {
        return realise;
    }

    public void setRealise(Date realise) {
        this.realise = realise;
    }

    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }
}
