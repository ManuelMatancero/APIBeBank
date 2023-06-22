package com.manuelsarante.ApiBeBank.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "transactions")
@Data
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long idTransaction;

    @Column(name = "transaction_type")
    private String transactionType;

    private double amount;

    private LocalDateTime date;

    private String description;

    @Column(name = "out_account")
    private String outAccount;

    @ManyToOne()
    @JoinColumn(name = "id_bankingaccount", referencedColumnName = "id_bankingaccount")
    private BankingAccount BankingAccount;

}