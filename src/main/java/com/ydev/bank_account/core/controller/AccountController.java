package com.ydev.bank_account.core.controller;

import com.ydev.bank_account.core.model.Account;
import com.ydev.bank_account.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    // Retorna todas as contas
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Retorna uma conta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable UUID id) {
        Optional<Account> account = accountService.getAccountById(id);
        if (account.isPresent()) {
            //200 OK
            return ResponseEntity.ok(account);
        } else {
            //404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccount(id);
        //204 No Content
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/all")
    public ResponseEntity<Void> deleteAllAccounts() {
        accountService.deleteAll();
        //204 No Content
        return ResponseEntity.noContent().build();
    }
}