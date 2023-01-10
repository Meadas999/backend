package com.jet.appback.services;

import com.jet.appback.models.Liked;
import com.jet.appback.models.Nuser;
import com.jet.appback.models.Reject;
import com.jet.appback.repository.LikedRepository;
import com.jet.appback.repository.NuserRepository;
import com.jet.appback.repository.RejectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NuserService {
    @Autowired
    private NuserRepository nuserRepository;

    @Autowired
    private LikedRepository likedRepository;
    @Autowired
    private RejectRepository rejectRepository;

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
            return null;
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
        Nuser user = nuserRepository.findByEmailAddress(email);
       List<Liked> likes = likedRepository.findAllByUserId(user.getId());
       List<Reject> rejects = rejectRepository.findAllByUserId(user.getId());
       List<Nuser> users = nuserRepository.findAllByEmailIsNotContainingAndGenderIsNot(email, user.getGender());
       List<Nuser> likedusers = new ArrayList<>();
       List<Nuser> rejectedusers = new ArrayList<>();
        for (Liked l: likes){
           likedusers.add(l.getLikeduser());
        }
        for(Reject r: rejects){
            rejectedusers.add(r.getRejecteduser());
        }
        users.removeAll(likedusers);
        users.removeAll(rejectedusers);

       return users;
    }






}
