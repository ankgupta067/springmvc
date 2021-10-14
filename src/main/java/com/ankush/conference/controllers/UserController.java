package com.ankush.conference.controllers;

import com.ankush.conference.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public User Get(@RequestParam(defaultValue = "Ankush") String firstName,
                    @RequestParam(defaultValue = "Gupta") String lastName,
                    @RequestParam(defaultValue = "33") int age){
        var user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

    @PostMapping()
    public ResponseEntity postUser(@RequestBody @Valid User user , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(bindingResult.toString(), HttpStatus.BAD_REQUEST);
        }
        System.out.println(user.getFirstName());
        return new ResponseEntity(user,HttpStatus.OK);
    }

}
