package com.manuelsarante.ApiBeBank.specialfunctions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePlus {


    public LocalDate calculateFiveYearsFromNow(LocalDate dateNow){
        // Calculate the date 5 years from now
        LocalDate dateWithin5Years = dateNow.plusYears(5);

        return dateWithin5Years;
    }


}
