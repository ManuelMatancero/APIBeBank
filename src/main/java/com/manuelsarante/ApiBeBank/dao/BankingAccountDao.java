package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingAccountDao extends JpaRepository<BankingAccount, Long> {

    BankingAccount findByIdAccount(Long id);

}
