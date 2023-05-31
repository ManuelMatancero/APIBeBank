package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.BankingAccount;

import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

public interface BankingAccountService {
    public List<BankingAccount> getAll();
    public BankingAccount findByIdAccount(Long id);
    public void insert(BankingAccount bankingAccount);
    public void update(BankingAccount bankingAccount);
    public void delete(BankingAccount bankingAccount);
}
