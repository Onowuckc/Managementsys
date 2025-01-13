package com.hms.managementsys.service;

import com.hms.managementsys.model.Loan;
import com.hms.managementsys.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private LoanRepository loanRepository;

    public LoanServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApplyForLoan() {
        Loan loan = new Loan();
        loan.setLoanAmount(10000.0);

        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        Loan createdLoan = loanService.applyForLoan(loan);
        assertEquals(10000.0, createdLoan.getLoanAmount());
    }

    @Test
    public void testGetAllLoans() {
        List<Loan> loanList = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setLoanAmount(10000.0);
        Loan loan2 = new Loan();
        loan2.setLoanAmount(20000.0);
        loanList.add(loan1);
        loanList.add(loan2);

        when(loanRepository.findAll()).thenReturn(loanList);

        List<Loan> loans = loanService.getAllLoans();
        assertEquals(2, loans.size());
    }

    @Test
    public void testGetLoanById() {
        Loan loan = new Loan();
        loan.setLoanId(1L);
        when(loanRepository.findById(1L)).thenReturn(java.util.Optional.of(loan));
        Loan foundLoan = loanService.getLoanById(1L);
        assertEquals(loan, foundLoan);
    }
}

