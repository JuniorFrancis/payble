package com.simple.payble.domain.usecases.implementations;

import com.simple.payble.domain.entities.WalletEntity;
import com.simple.payble.domain.usecases.interfaces.WalletManagerUseCase;
import com.simple.payble.ports.output.WalletOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletManagerUseCaseImpl implements WalletManagerUseCase {

    private final WalletOutputPort walletOutputPort;

    @Autowired
    public WalletManagerUseCaseImpl(WalletOutputPort walletOutputPort) {
        this.walletOutputPort = walletOutputPort;
    }

    @Override
    public void createWallet(int accountId) throws Exception {
        Long EMPTY = 0L;

        walletOutputPort.createWallet(
                new WalletEntity(accountId, EMPTY)
        );
    }

    @Override
    public boolean isValidWalletToDeactivateAccount(int accountId) {

        WalletEntity wallet = walletOutputPort.findByAccountId(accountId);

        return wallet.getAmount() <= 0;
    }
}
