package com.ydev.bank_account.core.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydev.bank_account.core.model.Account;
import com.ydev.bank_account.infra.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // Cria uma nova conta
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }

    /**
     * Busca todos as contas
     * @return Lista de contas
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Busca uma conta por ID
     * @param id ID da conta
     * @return Optional contendo a conta, se encontrada
     */
    public Optional<Account> getAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    /**
     * Busca uma conta por ID
     * @param id ID da conta
     */
    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }
}