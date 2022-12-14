package com.jet.appback.controllers;

import com.jet.appback.models.Nuser;
import com.jet.appback.services.NuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class NuserController {

    @Autowired
    private NuserService nuserService;
    private ClientRegistration registration;

    public NuserController(ClientRegistrationRepository registrations, NuserService nuserService ) {
        this.registration = registrations.findByRegistrationId("auth0");
        this.nuserService = nuserService;
    }


    @PostMapping
    public String add(@RequestBody Nuser nuser) {
        nuserService.adduser(nuser);
        return "New account has been made succesfull!";
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        // send logout URL to client so they can initiate logout
        StringBuilder logoutUrl = new StringBuilder();
        String issuerUri = this.registration.getProviderDetails().getIssuerUri();
        logoutUrl.append(issuerUri.endsWith("/") ? issuerUri + "v2/logout" : issuerUri + "/v2/logout");
        logoutUrl.append("?client_id=").append(this.registration.getClientId());

        Map<String, String> logoutDetails = new HashMap<>();
        logoutDetails.put("logoutUrl", logoutUrl.toString());
        request.getSession(false).invalidate();
        return ResponseEntity.ok().body(logoutDetails);
    }

    @GetMapping
    public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User ouser) {
        if (ouser == null) {
            return new ResponseEntity<>("", HttpStatus.OK);
        } else {
            Nuser user = nuserService.getuserbyemail(ouser.getAttribute("email"));
            return ResponseEntity.ok().body(user);
        }
    }

    @GetMapping("/allotherusers")
    public ResponseEntity<?> getAllOtherUsers(@AuthenticationPrincipal OAuth2User ouser)
    {
        if(ouser == null)
        {
          return new ResponseEntity<>("", HttpStatus.OK);
        }
        else
        {
            return ResponseEntity.ok().body(nuserService.getOtherUsersByEmail(ouser.getAttribute("email")));
        }
    }


}
