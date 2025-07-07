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
    private UUID ID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    @PrePersist
    void generatedID (){
        //Verification be ID is null
        if (this.ID == null){
            //Generated the UUID
            this.ID = UUID.randomUUID();
        }
    }

    public UUID getId() {
        return ID;
    }
}
