package com.manuelsarante.ApiBeBank.dto;

import lombok.Data;

@Data
public class TransactionDto {
    //Account you will be sending or reciving the money from
    private String outAccount;
    private double amount;
    //account of the actual user
    private String actualAccount;

}
