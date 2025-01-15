package com.hms.managementsys.service;

import com.hms.managementsys.model.Transaction;
import com.hms.managementsys.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction processPayment(Transaction transaction) {
        transaction.setType("Payment"); // Set the transaction type
        // Additional logic for processing payment can be added here
        return createTransaction(transaction); // Save the transaction
    }

    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
