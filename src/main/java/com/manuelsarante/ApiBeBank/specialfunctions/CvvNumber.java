package com.manuelsarante.ApiBeBank.specialfunctions;

import java.util.Random;

public class CvvNumber {

    public String generateNumber(){
        Random random = new Random();
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            numberBuilder.append(random.nextInt(10));
        }

        return numberBuilder.toString();
    }
}
