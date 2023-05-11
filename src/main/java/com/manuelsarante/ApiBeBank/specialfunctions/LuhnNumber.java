package com.manuelsarante.ApiBeBank.specialfunctions;

import java.util.Random;

public class LuhnNumber {

    // Generate a 16 digits number validated by Luhn
    public String generate() {
        Random random = new Random();
        StringBuilder numberBuilder = new StringBuilder();
        boolean isValid;
        do{
            // Generate the 15 first digits randomly
            for (int i = 0; i < 15; i++) {
                numberBuilder.append(random.nextInt(10));
            }
            // Calculates the last Luhn digit
            int luhnDigit = getLuhnDigit(numberBuilder.toString());
            numberBuilder.append(luhnDigit);

            isValid =validate(numberBuilder.toString());

        }while(!isValid);
        return numberBuilder.toString();
    }

    //With this I get the Luhn digits
    private int getLuhnDigit(String number) {
        int sum = 0;
        int digit;
        for (int i = number.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        return mod == 0 ? 0 : 10 - mod;
    }
//With this i validate the number
    public static boolean validate(String number) {
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
