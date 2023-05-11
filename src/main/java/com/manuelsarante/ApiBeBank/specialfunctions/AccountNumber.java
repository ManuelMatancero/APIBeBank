package com.manuelsarante.ApiBeBank.specialfunctions;

import java.util.Random;

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
