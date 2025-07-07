package com.ydev.bank_account.core.service;

import com.ydev.bank_account.core.model.Account;
import com.ydev.bank_account.core.model.User;
import com.ydev.bank_account.infra.repository.AccountRepository;
import com.ydev.bank_account.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    /**
     * Cria um novo usuário e automaticamente cria uma conta associada
     * @param user Usuário a ser criado
     * @return Usuário criado com ID gerado e conta associada
     */
    public User createUser(User user) {
       return userRepository.save(user);
    }

    /**
     * Busca todos os usuários
     * @return Lista de usuários
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Busca um usuário por ID
     * @param id ID do usuário
     * @return Optional contendo o usuário, se encontrado
     */
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    /**
     * Deleta um usuário por ID
     * @param id ID do usuário a ser deletado
     */
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    /**
     * Busca um usuário por email
     * @param email Email do usuário
     * @return Usuário encontrado ou null
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
