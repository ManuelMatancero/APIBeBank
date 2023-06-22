package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.dao.BankingAccountDao;
import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

@Service
public class BankingAccountServiceImpl implements BankingAccountService{
    @Autowired
    private BankingAccountDao bankingAccountDao;

    @Override
    @Transactional(readOnly = true)
    public List<BankingAccount> getAll() {
        return bankingAccountDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BankingAccount findByIdAccount(Long id) {
        return bankingAccountDao.findByIdAccount(id);
    }
    @Override
    @Transactional
    public void insert(BankingAccount bankingAccount) {
        bankingAccountDao.save(bankingAccount);
    }
    @Override
    @Transactional
    public void update(BankingAccount bankingAccount) {
        bankingAccountDao.save(bankingAccount);
    }
    @Override
    @Transactional
    public void delete(BankingAccount bankingAccount) {
        bankingAccountDao.delete(bankingAccount);
    }

    @Override
    public BankingAccount findByAccountNumber(String accountNumber) {
        return bankingAccountDao.findByAccountNumber(accountNumber);
    }
}
