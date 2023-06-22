package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.dao.TransactionsDao;
import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import com.manuelsarante.ApiBeBank.domain.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    TransactionsDao transactionsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Transactions> getAll() {
        return transactionsDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Transactions findById(Long id) {
        return transactionsDao.findById(id).orElse(null);
    }

    @Override
    public void insert(Transactions transactions) {
        transactionsDao.save(transactions);
    }

    @Override
    public void delete(Transactions transactions) {
            transactionsDao.delete(transactions);
    }

    @Override
    public void update(Transactions transactions) {
        transactionsDao.save(transactions);
    }
}
