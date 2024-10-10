package com.simple.payble.domain.entities;

import com.simple.payble.adapters.output.exceptions.InvalidAmountInWalletException;
import com.simple.payble.adapters.output.repositories.model.WalletModel;

public class WalletEntity {

    private Integer clientId;

    private Long amount;

    public WalletEntity(Integer clientId, Long amount) {

        if(amount < 0){
            throw new InvalidAmountInWalletException("Valor inválido para carteira");
        }

        this.clientId = clientId;
        this.amount = amount;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public static WalletEntity toWalletEntity(WalletModel walletModel) {
        return new WalletEntity(
                walletModel.getId(),
                walletModel.getAmount()
        );
    }
}
