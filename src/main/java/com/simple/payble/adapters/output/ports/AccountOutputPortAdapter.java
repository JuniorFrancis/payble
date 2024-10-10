package com.simple.payble.adapters.output.ports;

import com.simple.payble.adapters.output.exceptions.NonExistentAccountException;
import com.simple.payble.adapters.output.repositories.command.AccountRepository;
import com.simple.payble.adapters.output.repositories.model.AccountModel;
import com.simple.payble.domain.entities.AccountEntity;
import com.simple.payble.ports.output.AccountOutputPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.simple.payble.domain.entities.AccountEntity.toAccountEntity;
import static com.simple.payble.utils.IdentifierNumberUtils.sanitize;

@Service
public class AccountOutputPortAdapter implements AccountOutputPort {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountOutputPortAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Integer createAccount(AccountEntity accountEntity) {
        AccountModel accountModel = accountRepository.save(
                new AccountModel(
                        accountEntity.getUniqueIdentifierNumber(),
                        accountEntity.isActive(),
                        accountEntity.getType(),
                        LocalDateTime.now(),
                        accountEntity.getEmail(),
                        accountEntity.getName(),
                        accountEntity.getLastName()
                )
        );

        return accountModel.getId();
    }

    @Transactional
    public void deactivateAccount(AccountEntity account){

        if(account.isActive()){
            accountRepository.deactivateAccount(account.getUniqueIdentifierNumber());
        }
    }

    public AccountEntity findAccountByUniqueIdentifierNumber(String uniqueIdentifierNumber){
        AccountModel accountModel = accountRepository.findByUniqueIdentifierNumber(uniqueIdentifierNumber)
                .orElseThrow(NonExistentAccountException::new);

        return toAccountEntity(accountModel);

    }
}
