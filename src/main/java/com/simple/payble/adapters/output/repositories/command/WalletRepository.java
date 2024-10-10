package com.simple.payble.adapters.output.repositories.command;

import com.simple.payble.adapters.output.repositories.model.WalletModel;
import org.springframework.data.repository.Repository;

public interface WalletRepository extends Repository<WalletModel, Integer> {

    void save(WalletModel walletModel);

    WalletModel findByAccountId(Integer accountId);
}
