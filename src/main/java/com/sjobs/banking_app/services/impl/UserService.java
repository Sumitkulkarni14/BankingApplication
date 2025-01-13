package com.sjobs.banking_app.services.impl;

import com.sjobs.banking_app.dto.BankResponse;
import com.sjobs.banking_app.dto.UserInput;
import com.sjobs.banking_app.entity.UserProperties;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    BankResponse createAccount(UserInput userInput);
}
