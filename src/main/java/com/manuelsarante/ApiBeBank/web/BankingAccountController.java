package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import com.manuelsarante.ApiBeBank.service.BankingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankingAccountController {

    @Autowired
    BankingAccountService bankingAccountService;
    @PostMapping("/save")
    public ResponseEntity<?> saveBankingAccount(@RequestBody BankingAccount bankingAccount){
        bankingAccountService.insert(bankingAccount);
        return ResponseEntity.ok(bankingAccount);
    }
    @GetMapping("/list")
    public ResponseEntity<?> listBankingAccounts() {
        List<BankingAccount> bankingAccounts = bankingAccountService.getAll();
        return ResponseEntity.ok(bankingAccounts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankingAccount> getObjectById(@PathVariable Long id) {
        BankingAccount bankingAccount = bankingAccountService.findById(id);
        if (bankingAccount==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(bankingAccount);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletebankingAccount(@PathVariable Long id){
        BankingAccount bankingAccount = bankingAccountService.findById(id);
        bankingAccountService.delete(bankingAccount);
        return ResponseEntity.ok("BankingAccount Eliminado");
    }
}
