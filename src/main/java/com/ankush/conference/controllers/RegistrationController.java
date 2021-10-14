package com.ankush.conference.controllers;

import com.ankush.conference.models.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @GetMapping("registration")
    public String GetRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }

    @PostMapping("registration")
    public String AddRegistration( @Valid @ModelAttribute("registration")Registration registration,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Registration: has errors");
            return "registration";
        }
        System.out.println("Registration: " + registration.getName());
        return "redirect:registration";
    }
}
