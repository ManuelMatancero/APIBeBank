package com.manuelsarante.ApiBeBank.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCard")
public class Cards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cards")
    private Long idCard;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    private int cvv;
    @ManyToOne
    @JoinColumn(name = "id_bankingaccount", referencedColumnName = "id_bankingaccount")
    private BankingAccount bankingAccount;

}
