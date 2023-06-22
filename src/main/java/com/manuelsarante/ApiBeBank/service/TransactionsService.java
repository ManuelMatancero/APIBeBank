package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.Transactions;

import java.util.List;

public interface TransactionsService {

    List<Transactions> getAll();
    Transactions findById(Long id);
    void insert(Transactions transactions);
    void delete(Transactions transactions);
    void update(Transactions transactions);

}
