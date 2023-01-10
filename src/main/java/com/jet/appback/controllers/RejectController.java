package com.jet.appback.controllers;

import com.jet.appback.models.Nuser;
import com.jet.appback.models.Reject;
import com.jet.appback.services.NuserService;
import com.jet.appback.services.RejectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/reject")
public class RejectController {

    @Autowired
    private RejectService rejectService;

    @Autowired
    private NuserService nuserService;

    public RejectController(RejectService rejectService, NuserService nuserService)
    {
        this.rejectService = rejectService;
        this.nuserService = nuserService;
    }
@PostMapping
    public ResponseEntity<Object> addreject(@AuthenticationPrincipal OAuth2User user, @RequestBody Reject reject)
    {
        try
        {
        Nuser nuser = nuserService.getuserbyemail(user.getAttribute("email"));
        reject.setUser(nuser);
        reject.setReject_date(LocalDate.now());
        rejectService.addreject(reject);
        return ResponseEntity.ok().body("Succesfully rejected user");
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }


}
