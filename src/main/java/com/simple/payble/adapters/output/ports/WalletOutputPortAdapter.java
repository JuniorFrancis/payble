package com.simple.payble.adapters.output.ports;

import com.simple.payble.adapters.output.repositories.command.WalletRepository;
import com.simple.payble.adapters.output.repositories.model.WalletModel;
import com.simple.payble.domain.entities.WalletEntity;
import com.simple.payble.ports.output.WalletOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.simple.payble.domain.entities.WalletEntity.toWalletEntity;

@Service
public class WalletOutputPortAdapter implements WalletOutputPort {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletOutputPortAdapter(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void createWallet(WalletEntity wallet) {

        walletRepository.save(
                new WalletModel(
                        wallet.getClientId(),
                        wallet.getAmount(),
                        LocalDateTime.now()
                )
        );
    }

    @Override
    public WalletEntity findByAccountId(int accountId) {

        return toWalletEntity(
                walletRepository.findByAccountId(accountId)
        );
    }
}
