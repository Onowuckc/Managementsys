package com.hms.managementsys.service;

import com.hms.managementsys.model.Account;
import com.hms.managementsys.repository.AccountRepository; // Importing AccountRepository
import org.springframework.stereotype.Service; // Importing Service
import org.springframework.beans.factory.annotation.Autowired;



import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository; // Injecting the AccountRepository

    public List<Account> getAllAccounts() {
        // Logic to retrieve all accounts
        return new ArrayList<>(); // Placeholder return statement
    }

    public Account getAccountById(Long accountId) {
        // Logic to retrieve an account by ID
        return new Account(); // Placeholder return statement
    }

    public Account createAccount(Account account) {
        // Logic to create a new account
        return accountRepository.save(account); // Save the account and return the created account
    }

    public void updateAccount(Long accountId, Account account) {
        // Logic to update an existing account
    }

    public void deleteAccount(Long accountId) {
        // Logic to delete an account
    }
}
