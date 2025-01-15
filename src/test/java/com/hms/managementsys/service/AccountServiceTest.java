package com.hms.managementsys.service;

import com.hms.managementsys.model.Account;
import com.hms.managementsys.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    public AccountServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setType("Savings");
        account.setBalance(1000.0);

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account createdAccount = accountService.createAccount(account);
        assertEquals("Savings", createdAccount.getType());
    }

    @Test
    public void testGetAllAccounts() {
        Account account1 = new Account();
        account1.setType("Savings");
        account1.setBalance(1000.0);

        Account account2 = new Account();
        account2.setType("Current");
        account2.setBalance(2000.0);

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));

        List<Account> accounts = accountService.getAllAccounts();
        assertEquals(2, accounts.size());
    }

    @Test
    public void testDeleteAccount() {
        Long accountId = 1L;
        doNothing().when(accountRepository).deleteById(accountId);
        accountService.deleteAccount(accountId);
        verify(accountRepository, times(1)).deleteById(accountId);
    }

    @Test
    public void testUpdateAccount() {
        Long accountId = 1L;
        Account existingAccount = new Account();
        existingAccount.setAccountId(accountId);
        existingAccount.setType("Savings");
        existingAccount.setBalance(1000.0);

        when(accountRepository.existsById(accountId)).thenReturn(true);
        when(accountRepository.save(any(Account.class))).thenReturn(existingAccount);

        Account updatedAccount = accountService.updateAccount(accountId, existingAccount);
        assertEquals("Savings", updatedAccount.getType());
    }

    @Test
    public void testUpdateAccountNotFound() {
        Long accountId = 1L;
        Account account = new Account();
        account.setType("Savings");
        account.setBalance(1000.0);

        when(accountRepository.existsById(accountId)).thenReturn(false);

        Account updatedAccount = accountService.updateAccount(accountId, account);
        assertNull(updatedAccount);
    }
}
