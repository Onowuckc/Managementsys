package com.hms.managementsys.service;

import com.hms.managementsys.model.Transaction;
import com.hms.managementsys.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository; // Declare the repository

    public List<Transaction> getAllTransactions() {
        // Logic to retrieve all transactions
        return new ArrayList<>(); // Placeholder return statement
    }

    public Transaction getTransactionById(Long transactionId) {
        // Logic to retrieve a transaction by ID
        return new Transaction(); // Placeholder return statement
    }

    public Transaction createTransaction(Transaction transaction) {
        // Logic to create a new transaction
        transactionRepository.save(transaction); // Save the transaction
        return transaction; // Return the created transaction
    }

    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
        // Logic to update an existing transaction
        transactionRepository.save(transaction); // Save the updated transaction
        return transaction; // Return the updated transaction
    }

    public void deleteTransaction(Long transactionId) {
        // Logic to delete a transaction
    }
}
