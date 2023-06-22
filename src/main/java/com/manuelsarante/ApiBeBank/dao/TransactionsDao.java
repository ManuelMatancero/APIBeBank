package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Long> {
}
