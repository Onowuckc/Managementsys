package com.hms.managementsys.service;

import com.hms.managementsys.model.Transaction;
import com.hms.managementsys.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteTransaction() {
        Long transactionId = 1L; // Example transaction ID
        transactionService.deleteTransaction(transactionId);
        verify(transactionRepository, times(1)).deleteById(transactionId); // Verify that deleteById was called
    }

    // Other test cases...
}
