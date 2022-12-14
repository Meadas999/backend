package com.jet.appback.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Liked {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Nuser user;
    @OneToOne
    private Nuser likeduser;
    @Basic
    private LocalDate liked_date;
    @Basic
    private Boolean superlike;

    //Constructors
    public Liked() {}

    public Liked(long id, Nuser likeduser, LocalDate liked_date, Boolean superlike) {
        this.id = id;
        this.likeduser = likeduser;
        this.liked_date = liked_date;
        this.superlike = superlike;
    }

    public Liked(Nuser likeduser, LocalDate liked_date, Boolean superlike) {
        this.likeduser = likeduser;
        this.liked_date = liked_date;
        this.superlike = superlike;
    }

    //Methods

    public Nuser getUser() {
        return user;
    }

    public void setUser(Nuser user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Nuser getLikeduser() {
        return likeduser;
    }

    public void setLikeduser(Nuser likeduser) {
        this.likeduser = likeduser;
    }

    public LocalDate getLiked_date() {
        return liked_date;
    }

    public void setLiked_date(LocalDate liked_date) {
        this.liked_date = liked_date;
    }

    public Boolean getSuperlike() {
        return superlike;
    }

    public void setSuperlike(Boolean superlike) {
        this.superlike = superlike;
    }
}
