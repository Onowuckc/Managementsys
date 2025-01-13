package com.hms.managementsys.controller;

import com.hms.managementsys.model.Account;
import com.hms.managementsys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account account) {
        accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
