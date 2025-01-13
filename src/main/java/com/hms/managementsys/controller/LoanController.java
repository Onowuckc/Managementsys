package com.hms.managementsys.controller;

import com.hms.managementsys.model.Loan;
import com.hms.managementsys.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PostMapping
    public void createLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
    }

    @PutMapping("/{id}")
    public void updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        loanService.updateLoan(id, loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}
