package com.sjobs.banking_app.util;

import java.time.Year;
import java.util.Random;

public class AccountUtils {


    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "User Already Exists !!";
    public static final String ACCOUNT_CREATION_CODE = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "User Successfully Created !!";


    public static String generateAccountNumber(){
        /**
         * create a random account number starting with Year
         * RandomThreeAlphas + current Year + SixDigitRandom number
         */

        Random random = new Random();

        // Generate three random uppercase letters directly
        char firstLetter = (char) ('A' + random.nextInt(26));
        char secondLetter = (char) ('A' + random.nextInt(26));
        char thirdLetter = (char) ('A' + random.nextInt(26));
        String randomLetters = "" + firstLetter + secondLetter + thirdLetter;


        // Get the current year
        String currentYear = String.valueOf(Year.now().getValue());

        // Generate a random six-digit number
        int randomSixDigit = 100000 + random.nextInt(900000); // Ensures it's a 6-digit number

        // Combine random letters, year, and random number
        String randomNumber = randomLetters + currentYear + randomSixDigit;

        return randomNumber;
    }
}
