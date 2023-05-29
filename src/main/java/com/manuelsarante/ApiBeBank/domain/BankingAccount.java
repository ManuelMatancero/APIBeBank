package com.manuelsarante.ApiBeBank.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


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

    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "mount_account")
    private double mountAccount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cards", referencedColumnName = "id_cards")
    private Cards cards;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

}
