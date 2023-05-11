package com.manuelsarante.ApiBeBank.specialfunctions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DatePlus {


    public Date calculateFiveYearsFromNow(LocalDate dateNow){
        // Calculate the date 5 years from now
        LocalDate dateWithin5Years = dateNow.plusYears(5);

        // Convert the LocalDate object to a Date object
        Date date = Date.from(dateWithin5Years.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return date;
    }


}
