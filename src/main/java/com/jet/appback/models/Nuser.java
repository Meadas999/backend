package com.jet.appback.models;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Nuser extends BaseUser
{
    //Fields
    @Basic
    private String gender;
    @Basic
    private String genderpreference;

    @OneToMany(mappedBy = "user")
    private List<Liked> liked;

    @OneToMany(mappedBy = "user")
    private List<Reject> rejects;

    //Constructors
    public Nuser(String firstname, String lastname, String insertion, LocalDate birthdate) {
        super(firstname, lastname, insertion, birthdate);
    }
    public Nuser() {

    }

    //Methods
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGenderpreference() {
        return genderpreference;
    }
    public void setGenderpreference(String genderpreference) {
        this.genderpreference = genderpreference;
    }
}


