package com.jet.appback.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Nuser extends BaseUser
{
    public Nuser(String firstname, String lastname, String insertion, LocalDate birthdate) {
        super(firstname, lastname, insertion, birthdate);
    }

    public Nuser() {

    }
}
