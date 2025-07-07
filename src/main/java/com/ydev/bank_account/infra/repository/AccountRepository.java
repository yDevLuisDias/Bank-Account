package com.ydev.bank_account.infra.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ydev.bank_account.core.model.Account;

@Repository
public interface AccountRepository extends  JpaRepository<Account, UUID> {

    // Custom query methods can be defined here if needed
    // For example, to find accounts by account holder name:

}
