package com.hms.managementsys.controller;

import com.hms.managementsys.model.Transaction;
import com.hms.managementsys.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public void processPayment(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
