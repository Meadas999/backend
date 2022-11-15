package com.jet.appback.controllers;

import com.jet.appback.configuration.SecurityConfig;
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
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class NuserController {

    @Autowired
    private NuserService nuserService;
    private ClientRegistration registration;

    public NuserController(ClientRegistrationRepository registrations) {
        this.registration = registrations.findByRegistrationId("auth0");
    }

    @PostMapping("/user")
    public String add(@RequestBody Nuser nuser) {
        nuserService.adduser(nuser);
        return "New account has been made succesfull!";
    }

    @PostMapping("/user/logout")
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

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return new ResponseEntity<>("", HttpStatus.OK);
        } else {
            return ResponseEntity.ok().body(user.getAttributes());

        }
    }

    @GetMapping("/user/userpage")
    public ResponseEntity<?> userpage(@AuthenticationPrincipal OAuth2User userauth)
    {
        if (userauth == null)
        {
            return new ResponseEntity<>("", HttpStatus.OK);
        }
            else
            {
                String enteredemail = userauth.getAttribute("email").toString();
                Nuser user = nuserService.getuser(enteredemail);
                return ResponseEntity.ok().body(user);
            }
    }



}
