package com.manuelsarante.ApiBeBank.specialfunctions;

import java.util.Random;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

public class AccountNumber {


    public String generateNumber(){
        Random random = new Random();
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            numberBuilder.append(random.nextInt(10));
        }

        return numberBuilder.toString();
    }


}
