package com.manuelsarante.ApiBeBank.specialfunctions;

import lombok.Data;

@Data
public class Messages {
    private String message;

    public Messages(){};
    public Messages(String message){
        this.message = message;
    }
}
