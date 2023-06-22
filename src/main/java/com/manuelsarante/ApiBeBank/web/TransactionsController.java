package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.BankingAccount;
import com.manuelsarante.ApiBeBank.domain.Transactions;
import com.manuelsarante.ApiBeBank.dto.TransactionDto;
import com.manuelsarante.ApiBeBank.service.BankingAccountService;
import com.manuelsarante.ApiBeBank.service.TransactionsService;
import com.manuelsarante.ApiBeBank.specialfunctions.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @Autowired
    BankingAccountService bankingAccountService;

    @PostMapping("/transfer")
    ResponseEntity<?> saveTransaction(@RequestBody TransactionDto transactionDto){

        Transactions actualUserTransaction = new Transactions();
        Transactions receiverUserTransaction = new Transactions();
        double amount = transactionDto.getAmount();
        BankingAccount outbankingAccount = bankingAccountService.findByAccountNumber(transactionDto.getOutAccount());
        BankingAccount actualBankingAccount = bankingAccountService.findByAccountNumber(transactionDto.getActualAccount());
        if(actualBankingAccount!=null && outbankingAccount!=null){
            //Actual user functionality
            //here i do the operations to subtract the amonut sent and the amount of the account.
            if(amount > actualBankingAccount.getMountAccount()){
                return ResponseEntity.ok(new Messages("The amount to send exceeds the available amount in this account"));
            }else {
                //here i subtract the actual amount of the account with the amount to send
                actualBankingAccount.setMountAccount(actualBankingAccount.getMountAccount()-amount);
                bankingAccountService.update(actualBankingAccount);
                //Here I proceed to save the information of the actualUsertransaction to be saved
                actualUserTransaction.setTransactionType("TRANSFERRED");
                actualUserTransaction.setAmount(amount);
                actualUserTransaction.setDate(LocalDateTime.now());
                actualUserTransaction.setDescription("Transferred " + amount + " to " + outbankingAccount.getUser().getName());
                actualUserTransaction.setOutAccount(transactionDto.getOutAccount());
                actualUserTransaction.setBankingAccount(actualBankingAccount);
                //here i insert That transaction
                transactionsService.insert(actualUserTransaction);

                //Here i update the amount acount of the outAccount
                outbankingAccount.setMountAccount(outbankingAccount.getMountAccount() + amount);
                bankingAccountService.update(outbankingAccount);
                receiverUserTransaction.setTransactionType("RECEIVED");
                receiverUserTransaction.setAmount(amount);
                receiverUserTransaction.setDate(LocalDateTime.now());
                receiverUserTransaction.setDescription("Received " + amount + " from " + actualBankingAccount.getUser().getName());
                receiverUserTransaction.setOutAccount(actualBankingAccount.getAccountNumber());
                receiverUserTransaction.setBankingAccount(outbankingAccount);
                transactionsService.insert(receiverUserTransaction);
                return ResponseEntity.ok(actualUserTransaction);
            }

        }else{
            return ResponseEntity.notFound().build();
        }
        //Receiver user functionality
    }





}
