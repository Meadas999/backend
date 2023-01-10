package com.jet.appback.models;

import reactor.util.annotation.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reject {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Nuser user;
    @OneToOne
    private Nuser rejecteduser;
    @Basic
    private LocalDate reject_date;

    //Constructors
    public Reject() {}

    public Reject(long id, Nuser rejecteduser, LocalDate reject_date) {
        this.id = id;
        this.rejecteduser = rejecteduser;
        this.reject_date = reject_date;

    }

    public Reject(Nuser rejecteduser, LocalDate reject_date) {
        this.rejecteduser = rejecteduser;
        this.reject_date = reject_date;
    }

    //Methods
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Nuser getUser() {
        return user;
    }

    public void setUser(Nuser user) {
        this.user = user;
    }

    public Nuser getRejecteduser() {
        return rejecteduser;
    }

    public void setRejecteduser(Nuser rejecteduser) {
        this.rejecteduser = rejecteduser;
    }

    public LocalDate getReject_date() {
        return reject_date;
    }

    public void setReject_date(LocalDate reject_date) {
        this.reject_date = reject_date;
    }


}
