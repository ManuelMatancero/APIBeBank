package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
public interface BankingAccountDao extends JpaRepository<BankingAccount, Long> {

    BankingAccount findByIdAccount(Long id);

}
