import com.ydev.bank_account.core.model.Account;
import com.ydev.bank_account.infra.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ApplicationTest {

    private AccountRepository accountRepository;

    @Test
    void testSaveAndFindAccount() {
        // Cria uma nova conta
        Account account = new Account();
        account.setAccountNumber("123456");
        account.setBalance(1000.0);

        // Salva a conta no banco de dados
        Account savedAccount = accountRepository.save(account);

        // Verifica se a conta foi salva corretamente
        assertThat(savedAccount.getId()).isNotNull();
        assertThat(savedAccount.getAccountNumber()).isEqualTo("123456");
        assertThat(savedAccount.getBalance()).isEqualTo(1000.0);

        // Busca a conta pelo ID
        Optional<Account> retrievedAccount = accountRepository.findById(savedAccount.getId());

        // Verifica se a conta foi encontrada
        assertThat(retrievedAccount).isPresent();
        assertThat(retrievedAccount.get().getAccountNumber()).isEqualTo("123456");
    }

    @Test
    void testDeleteAccount() {
        // Cria e salva uma conta
        Account account = new Account();
        account.setAccountNumber("654321");
        account.setBalance(500.0);
        Account savedAccount = accountRepository.save(account);

        // Deleta a conta
        accountRepository.deleteById(savedAccount.getId());

        // Verifica se a conta foi deletada
        Optional<Account> deletedAccount = accountRepository.findById(savedAccount.getId());
        assertThat(deletedAccount).isEmpty();
    }
}