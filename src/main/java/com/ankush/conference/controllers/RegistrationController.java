package com.ankush.conference.controllers;

import com.ankush.conference.models.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @GetMapping("registration")
    public String GetRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }

    @PostMapping("registration")
    public String AddRegistration(@ModelAttribute("registration")Registration registration){
        System.out.println("Registration: " + registration.getName());
        return "redirect:registration";
    }
}
