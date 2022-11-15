package com.jet.appback.services;

import com.jet.appback.models.Nuser;
import com.jet.appback.repository.NuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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
    public Nuser getuser(String email)
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






}
