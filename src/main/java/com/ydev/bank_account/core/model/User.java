package com.ydev.bank_account.core.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    /**
     * unique = Depois de criado, o UUID não pode ser duplicado.
     * updatable = Depois de criado, o UUID não pode ser alterado.
     * nullable = O campo UUID, não pode ser vazio.
     */
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID Id;

    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Account account;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

}
