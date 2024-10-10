package com.simple.payble.domain.usecases.interfaces;

public interface WalletManagerUseCase {

    void createWallet(int accountId) throws Exception;

    boolean isValidWalletToDeactivateAccount(int accountId);

}
