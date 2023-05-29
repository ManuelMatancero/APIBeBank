package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import com.manuelsarante.ApiBeBank.domain.Cards;
import com.manuelsarante.ApiBeBank.domain.User;
import com.manuelsarante.ApiBeBank.dto.UpdateAmountAccountDto;
import com.manuelsarante.ApiBeBank.service.BankingAccountService;
import com.manuelsarante.ApiBeBank.service.CardsService;
import com.manuelsarante.ApiBeBank.specialfunctions.AccountNumber;
import com.manuelsarante.ApiBeBank.specialfunctions.CvvNumber;
import com.manuelsarante.ApiBeBank.specialfunctions.DatePlus;
import com.manuelsarante.ApiBeBank.specialfunctions.LuhnNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/account")
public class BankingAccountController {

    @Autowired
    BankingAccountService bankingAccountService;

    @Autowired
    CardsService cardsService;


    //With this method you only have to set the id of the user you want to add a new account in the end point and in the body you set the amount you are going to have in the account
    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveBankingAccount(@PathVariable Long id, @RequestBody UpdateAmountAccountDto updateAmountAccountDto){
        //First generate the banking account, the card number, the expire date of the card and Cvv of the card
        String accountNumber = new AccountNumber().generateNumber();
        String cardNumber = new LuhnNumber().generate();
        LocalDate expireDate = new DatePlus().calculateFiveYearsFromNow(LocalDate.now());
        String cvv = new CvvNumber().generateNumber();
        //Here we get a list of Accounts and cards to be sure in not create a card with same number or an account
        List<BankingAccount> bankingAccounts = bankingAccountService.getAll();
        List<Cards> cards = cardsService.getAll();
        for(BankingAccount bankingAccount1: bankingAccounts){
            if (bankingAccount1.getAccountNumber().equals(accountNumber)){
                accountNumber = new AccountNumber().generateNumber();
            }else{
                break;
            }
        }
        for(Cards cards1: cards){
            if (cards1.getCardNumber().equals(cardNumber)){
                cardNumber = new LuhnNumber().generate();
            }else{
                break;
            }
        }
        //Create the user
        User user = new User();
        //to the user we only set the id of the user which the account is gonna be related with
        user.setIdUser(id);
        //Create the bankingAccount
        BankingAccount bankingAccountToSave = new BankingAccount();
        //Create the card
        Cards cardToSave = new Cards();
        //Set the values to the card
        cardToSave.setCardNumber(cardNumber);
        cardToSave.setCreationDate(LocalDate.now());
        cardToSave.setExpireDate(expireDate);
        cardToSave.setCvv(Integer.parseInt(cvv));
        //Set The values to the banking account
        bankingAccountToSave.setAccountNumber(accountNumber);
        bankingAccountToSave.setUser(user);
        bankingAccountToSave.setMountAccount(updateAmountAccountDto.getMount());
        bankingAccountToSave.setCards(cardToSave);

        bankingAccountService.insert(bankingAccountToSave);
        return ResponseEntity.ok(bankingAccountToSave);
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
