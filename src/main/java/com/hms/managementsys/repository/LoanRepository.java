 package com.hms.managementsys.repository;

import com.hms.managementsys.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
