package com.simple.payble.ports.output;

import com.simple.payble.adapters.output.repositories.model.WalletModel;
import com.simple.payble.domain.entities.WalletEntity;

public interface WalletOutputPort {

    void createWallet(WalletEntity wallet);

    WalletEntity findByAccountId(int accountId);

}
