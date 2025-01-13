package com.sjobs.banking_app.controller;

import com.sjobs.banking_app.dto.BankResponse;
import com.sjobs.banking_app.dto.UserInput;
import com.sjobs.banking_app.entity.UserProperties;
import com.sjobs.banking_app.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/bankApi")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/addUser")
    public BankResponse createAccount(@RequestBody UserInput userInput){
        System.out.println("Inside controller");
        return userService.createAccount(userInput);
    }

    @GetMapping("/getUser")
    public String createAccount(){
        return "Get";
    }
}
