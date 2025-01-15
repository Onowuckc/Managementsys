package com.hms.managementsys.service;

import com.hms.managementsys.model.Account;
import com.hms.managementsys.repository.AccountRepository; // Importing AccountRepository
import org.springframework.stereotype.Service; // Importing Service
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository; // Injecting the AccountRepository

    public List<Account> getAllAccounts() {
        // Logic to retrieve all accounts
        return accountRepository.findAll(); // Retrieve all accounts from the repository
    }

    public Account getAccountById(Long accountId) {
        // Logic to retrieve an account by ID
        return accountRepository.findById(accountId).orElse(null); // Retrieve account by ID
    }
    
    public Account createAccount(Account account) {
        // Logic to create a new account
        return accountRepository.save(account); // Save the account and return the created account
    }

    public Account updateAccount(Long accountId, Account account) {
        // Logic to update an existing account
        if (accountRepository.existsById(accountId)) {
            account.setAccountId(accountId); // Set the ID of the account to be updated
            return accountRepository.save(account); // Save the updated account
        }
        return null; // Return null if the account does not exist
    }

    public void deleteAccount(Long accountId) {
        // Logic to delete an account
        accountRepository.deleteById(accountId); // Delete the account by ID
    }
}
