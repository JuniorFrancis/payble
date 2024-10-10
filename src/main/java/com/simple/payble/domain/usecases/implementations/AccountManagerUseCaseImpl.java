package com.simple.payble.domain.usecases.implementations;

import com.simple.payble.adapters.output.exceptions.InvalidAmountInWalletException;
import com.simple.payble.domain.entities.AccountEntity;
import com.simple.payble.domain.enums.TransactionTypes;
import com.simple.payble.domain.usecases.interfaces.AccountManagerUseCase;
import com.simple.payble.domain.usecases.interfaces.WalletManagerUseCase;
import com.simple.payble.ports.output.AccountOutputPort;
import com.simple.payble.ports.output.EngineMessageOutputPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.simple.payble.utils.IdentifierNumberUtils.sanitize;

@Service
public class AccountManagerUseCaseImpl implements AccountManagerUseCase {

    private final AccountOutputPort accountOutputPort;

    private final WalletManagerUseCase walletManagerUseCase;

    private final EngineMessageOutputPort engineMessageOutputPort;

    @Autowired
    public AccountManagerUseCaseImpl(
            AccountOutputPort accountOutputPort,
            EngineMessageOutputPort engineMessageOutputPort,
            WalletManagerUseCase walletManagerUseCase
    ) {
        this.accountOutputPort = accountOutputPort;
        this.engineMessageOutputPort = engineMessageOutputPort;
        this.walletManagerUseCase = walletManagerUseCase;
    }

    @Override
    @Transactional
    public void creatingAccount(AccountEntity account) throws Exception {

        Integer accountId = accountOutputPort.createAccount(account);

        walletManagerUseCase.createWallet(accountId);
        engineMessageOutputPort.publish(TransactionTypes.OPENING_ACCOUNT, account);
    }

    public void deactivateAccount(String uniqueIdentifierNumber){
        AccountEntity account = accountOutputPort.findAccountByUniqueIdentifierNumber(sanitize(uniqueIdentifierNumber));

        if(!walletManagerUseCase.isValidWalletToDeactivateAccount(account.getAccountId())){
            throw new InvalidAmountInWalletException("Conta impossibilitada de ser desativa pois ainda há valor disponível na carteira");
        }

        accountOutputPort.deactivateAccount(account);
    }
}
