package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.dao.BankingAccountDao;
import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public BankingAccount findById(Long id) {
        return bankingAccountDao.findById(id).orElse(null);
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
}
