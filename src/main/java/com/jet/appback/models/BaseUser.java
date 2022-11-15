package com.jet.appback.models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public abstract class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true)
    private String email;

    private String firstname;
    private String lastname;
    private String insertion;
    private LocalDate birthdate;
    /*private boolean FullyRegistered;*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public BaseUser() {
    }

    public BaseUser(String firstname, String lastname, String insertion, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.insertion = insertion;
        this.birthdate = birthdate;
    }

    public BaseUser(long id, String firstname, String lastname, String insertion, LocalDate birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.insertion = insertion;
        this.birthdate = birthdate;
    }


    public long getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname){this.firstname = firstname;}
    public String getLastname() {return lastname;}
    public void setLastname(String lastname){this.lastname = lastname;}
    public String getInsertion() {
        return insertion;
    }
    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
