package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import com.manuelsarante.ApiBeBank.dto.UpdateAmountAccountDto;
import com.manuelsarante.ApiBeBank.service.BankingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class BankingAccountController {

    @Autowired
    BankingAccountService bankingAccountService;


    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveBankingAccount(@PathVariable Long id, @RequestBody BankingAccount bankingAccount){
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////Me Quede Trabajando Aqui////////////////////////////////////////////////////////////

        bankingAccountService.insert(bankingAccount);
        return ResponseEntity.ok(bankingAccount);
    }

    @PutMapping("/updateMount/{id}")
    public ResponseEntity<?> updateBankingAccount(@PathVariable Long id, @RequestBody UpdateAmountAccountDto uAaDto){
        BankingAccount bankingAcc = bankingAccountService.findByIdAccount(id);
        if (bankingAcc==null) {
            return ResponseEntity.notFound().build();
        }else{
            bankingAcc.setMountAccount(uAaDto.getMount());
            bankingAccountService.insert(bankingAcc);
            return ResponseEntity.ok(bankingAcc);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> listBankingAccounts() {
        List<BankingAccount> bankingAccounts = bankingAccountService.getAll();
        return ResponseEntity.ok(bankingAccounts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankingAccount> getObjectById(@PathVariable Long id) {
        BankingAccount bankingAccount = bankingAccountService.findByIdAccount(id);
        if (bankingAccount==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(bankingAccount);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletebankingAccount(@PathVariable Long id){
        BankingAccount bankingAccount = bankingAccountService.findByIdAccount(id);
        bankingAccountService.delete(bankingAccount);
        return ResponseEntity.ok("BankingAccount Eliminado");
    }
}
