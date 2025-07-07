package com.ydev.bank_account.core.controller;

import com.ydev.bank_account.core.model.User;
import com.ydev.bank_account.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Cria um novo usuário
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Lista todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Busca um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        return userService.getUserById(id)
                //ResponseEntity :: ok = 200 OK
                .map(ResponseEntity::ok)
                //ResponseEntity.notFound = 404 Not Found
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta um usuário por ID
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/email/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        userService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllUsers() {
        userService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}