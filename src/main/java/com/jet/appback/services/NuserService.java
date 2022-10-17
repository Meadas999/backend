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



}
