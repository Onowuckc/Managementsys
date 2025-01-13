package com.hms.managementsys.repository;

import com.hms.managementsys.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
