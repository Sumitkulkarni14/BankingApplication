package com.sjobs.banking_app.services.impl;

import com.sjobs.banking_app.dto.AccountInfo;
import com.sjobs.banking_app.dto.BankResponse;
import com.sjobs.banking_app.dto.UserInput;
import com.sjobs.banking_app.entity.UserProperties;
import com.sjobs.banking_app.repo.UserRepository;
import com.sjobs.banking_app.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserInput userInput) {
        /**
         * Check if Account is already present
         * Creating a new user into DB
         */

        if(userRepository.existsByEmail(userInput.getEmail())){
//            BankResponse response = BankResponse.builder()
//                    .responseCode(AccountUtils.ACCOUNT_EXIST_CODE)
//                    .responseMessage(AccountUtils.ACCOUNT_EXIST_MESSAGE)
//                    .accountInfo(null)
//                    .build();
            BankResponse response = new BankResponse();
            response.setResponseCode(AccountUtils.ACCOUNT_EXIST_CODE);
            response.setResponseMessage(AccountUtils.ACCOUNT_EXIST_MESSAGE);
            response.setAccountInfo(null);
            return response;
        }

        UserProperties newUser = new UserProperties();
                newUser.setFirstName(userInput.getFirstName());
                newUser.setLastName(userInput.getLastName());
                newUser.setOtherName(userInput.getOtherName());
                newUser.setGender(userInput.getGender());
                newUser.setAddress(userInput.getAddress());
                newUser.setStateOfOrigin(userInput.getStateOfOrigin());
                newUser.setAccountNumber(AccountUtils.generateAccountNumber());
                newUser.setEmail(userInput.getEmail());
                newUser.setAccountBalance(BigDecimal.ZERO);
                newUser.setPhoneNumber(userInput.getPhoneNumber());
                newUser.setAlternatePhoneNumber(userInput.getAlternatePhoneNumber());
                newUser.setStatus("ACTIVE");

    UserProperties savedUser = userRepository.save(newUser);

//    BankResponse newResponse =  BankResponse.builder()
//            .responseCode(AccountUtils.ACCOUNT_CREATION_CODE)
//            .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
//            .accountInfo(AccountInfo.builder()
//                    .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
//                    .accountBalance(savedUser.getAccountBalance())
//                    .accountNumber(savedUser.getAccountNumber())
//                    .build())
//            .build();
        BankResponse newResponse = new BankResponse();
        AccountInfo accinfo = new AccountInfo();
        accinfo.setAccountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName());
        accinfo.setAccountBalance(savedUser.getAccountBalance());
        accinfo.setAccountNumber(savedUser.getAccountNumber());
        newResponse.setResponseCode(AccountUtils.ACCOUNT_CREATION_CODE);
        newResponse.setResponseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE);
        newResponse.setAccountInfo(accinfo);

    return newResponse;
    }
}
