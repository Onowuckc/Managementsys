package com.hms.managementsys.service;

import com.hms.managementsys.model.Loan;
import com.hms.managementsys.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        // Logic to retrieve all loans
        return loanRepository.findAll(); // Return the list of loans from the repository
    }

    public Loan getLoanById(Long loanId) {
        // Logic to retrieve a loan by ID
        return loanRepository.findById(loanId).orElse(null); // Return the loan if found, otherwise null
    }

    public void createLoan(Loan loan) {
        // Logic to create a new loan
        loanRepository.save(loan); // Save the loan to the repository
    }

    public void updateLoan(Long loanId, Loan loan) {
        // Logic to update an existing loan
        if (loanRepository.existsById(loanId)) {
            loan.setLoanId(loanId); // Set the ID of the loan to be updated
            loanRepository.save(loan); // Save the updated loan
        }
    }

    public void deleteLoan(Long loanId) {
        // Logic to delete a loan
        loanRepository.deleteById(loanId); // Delete the loan by ID
    }

    public Loan applyForLoan(Loan loan) {
        // Logic to apply for a loan
        return loanRepository.save(loan); // Save the loan and return the created loan
    }
}
