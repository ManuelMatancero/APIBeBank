package com.manuelsarante.ApiBeBank.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bankingaccount")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAccount")
public class BankingAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bankingaccount")
    private Long idAccount;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
    @Column(name = "account_number")
    private int accountNumber;
    @Column(name = "mount_account")
    private double mountAccount;
    @OneToMany
    @JoinColumn(name = "id_bankingaccount")
    private List<Cards> cards;



}
