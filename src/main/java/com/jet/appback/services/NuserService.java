package com.jet.appback.services;

import com.jet.appback.models.Nuser;
import com.jet.appback.repository.NuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NuserService {
    @Autowired
    private NuserRepository nuserRepository;

    public List<Nuser> list()
    {
        return nuserRepository.findAll();
    }

    public void adduser(Nuser nuser)
    {
        nuserRepository.save(nuser);
    }

    public long GetIdByEmail(String email) { return nuserRepository.findIdByEmail(email); }

    public String updateuser(Nuser nuser)
    {
        if(nuser.getId() == 0)
        {
            return "User is not valid";
        }
        else
        {
            nuserRepository.save(nuser);
            return  "User is updated succesfull";
        }
    }
    public Nuser getuserbyemail(String email)
    {
        Nuser user = nuserRepository.findByEmailAddress(email);
        if(user != null)
        {
            return user;
        }
        else
        {
            throw new RuntimeException("User doesn't exist");
        }

    }
    public Nuser getUserById(long id)
    {
        Nuser user = nuserRepository.getReferenceById(id);
        if(user != null)
        {
            return user;
        }
        else
        {
            throw new RuntimeException("User doesn't exist");
        }

    }

    public List<Nuser> getOtherUsersByEmail(String email)
    {
       List<Nuser> users = nuserRepository.findAllByEmailIsNotContaining(email);
       return users;
    }






}
