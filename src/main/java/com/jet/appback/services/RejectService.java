package com.jet.appback.services;

import com.jet.appback.models.Reject;
import com.jet.appback.repository.LikedRepository;
import com.jet.appback.repository.RejectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RejectService {
    @Autowired
    private RejectRepository rejectRepository;

    public List<Reject> getAllRejectsFromUserById(long userid)
    {
       return rejectRepository.findAllByUserId(userid);
    }

    public void addreject(Reject reject)
    {
        rejectRepository.save(reject);
    }

    public void deletereject(Reject reject)
    {
        rejectRepository.delete(reject);
    }





}
