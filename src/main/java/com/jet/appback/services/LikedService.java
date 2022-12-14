package com.jet.appback.services;

import com.jet.appback.models.Liked;
import com.jet.appback.repository.LikedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedService {

    private LikedRepository likedRepository;

    public List<Liked> getAllLikesFromUserById(long userid)
    {
       return likedRepository.findAllByUserId(userid);
    }

    public void addLike(Liked like)
    {
        likedRepository.save(like);
    }

    public void deleteLike(Liked like)
    {
        likedRepository.delete(like);
    }





}
