package com.jet.appback.models;



import com.jet.appback.formModels.Registeruser;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public Nuser(long id, String email, String firstname, String lastname, String insertion, LocalDate birthdate,
                 String gender, String genderpreference, List<Liked> liked, List<Reject> rejects) {
        super(id, email, firstname, lastname, insertion, birthdate);
        this.gender = gender;
        this.genderpreference = genderpreference;
        this.liked = liked;
        this.rejects = rejects;
    }

    public Nuser() {

    }
    public Nuser(Registeruser registeruser)
    {
        super(registeruser.getFirstname(),registeruser.getLastname(),registeruser.getInsertion());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(registeruser.getBirthdate(),formatter);
        this.setBirthdate(date);
        this.gender = registeruser.getGender();
        this.genderpreference = registeruser.getGenderpreference();

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


