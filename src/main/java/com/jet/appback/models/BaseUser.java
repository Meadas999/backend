package com.jet.appback.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public abstract class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String FirstName;

    private String LastName;
    private String Insertion;
    private LocalDate Birthdate;

    public BaseUser() {
    }

    public BaseUser(int id, String firstName, String lastName, String insertion, LocalDate birthdate) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Insertion = insertion;
        Birthdate = birthdate;
    }

    public int getId()
    {
        return Id;
    }
    public void setId(int id)
    {
        this.Id = id;
    }
    public String getFirstName() {return FirstName;}
    public void setFirstName(String firstName){this.FirstName = firstName;}
    public String getLastName() {return LastName;}
    public void setLastName(String lastName){this.LastName = lastName;}
    public String getInsertion() {
        return Insertion;
    }
    public void setInsertion(String insertion) {
        Insertion = insertion;
    }
    public LocalDate getBirthdate() {
        return Birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        Birthdate = birthdate;
    }
}
