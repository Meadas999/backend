package com.jet.appback.controllers;

import com.jet.appback.models.Liked;
import com.jet.appback.models.Nuser;
import com.jet.appback.services.LikedService;
import com.jet.appback.services.NuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/like")
public class LikedController {
    @Autowired
    LikedService likedService = new LikedService();
    @Autowired
    NuserService nuserService = new NuserService();

    public LikedController(LikedService likedService, NuserService nuserService) {
        this.likedService = likedService;
        this.nuserService = nuserService;
    }

    @PostMapping("/liked")
    public ResponseEntity<?> AddLikeToUser(@AuthenticationPrincipal OAuth2User ouser, @RequestBody Liked like)
    {
        if(like == null || ouser == null)
        {
            return ResponseEntity.ok().body("Something went wrong.");
        }
        else
        {
            Nuser user = nuserService.getuserbyemail(ouser.getAttribute("email"));
            like.setUser(user);
            like.setLiked_date(LocalDate.now());
            likedService.addLike(like);
            return ResponseEntity.ok().body("Person has been successfully liked");
        }
    }
}
