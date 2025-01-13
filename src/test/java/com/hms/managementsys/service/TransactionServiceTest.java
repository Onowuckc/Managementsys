package com.hms.managementsys.service;

import com.hms.managementsys.model.Transaction;
import com.hms.managementsys.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    public TransactionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setType("Deposit");
        transaction.setAmount(500.0);

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Transaction createdTransaction = transactionService.createTransaction(transaction);
        assertEquals("Deposit", createdTransaction.getType());
    }

    @Test
    public void testGetAllTransactions() {
        Transaction transaction1 = new Transaction();
        transaction1.setType("Deposit");
        transaction1.setAmount(500.0);

        Transaction transaction2 = new Transaction();
        transaction2.setType("Withdrawal");
        transaction2.setAmount(200.0);

        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        List<Transaction> transactions = transactionService.getAllTransactions();
        assertEquals(2, transactions.size());
    }
}
