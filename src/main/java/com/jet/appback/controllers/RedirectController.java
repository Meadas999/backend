package com.jet.appback.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin("http://localhost:3000/")
@Controller
@Profile("prod")
public class RedirectController {

    @GetMapping("/private")
    public String redirectToRoot() {
        return "redirect:/";
    }
}
