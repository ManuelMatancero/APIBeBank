package com.manuelsarante.ApiBeBank.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

@Entity
@Table(name = "user")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "Name")
    private String name;
    private String email;
    private String user;
    private String password;
    private int role;
    private int status;
    private String pin;
   // @OneToMany
    // @JoinColumn(name = "id_user", referencedColumnName = "id_user")
   // private List<Logs> logs;
    @OneToMany
    @JoinColumn(name="id_user", referencedColumnName = "id_user")
    private List<BankingAccount> bankingAccounts;

}
