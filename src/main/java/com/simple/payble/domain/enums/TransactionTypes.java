package com.simple.payble.domain.enums;

public enum TransactionTypes {

    OPENING_ACCOUNT("openingAccount");

    private String transactionType;

    TransactionTypes(String transactionType) {}

    public String getTransactionType() {
        return transactionType;
    }
}
