package com.simple.payble.adapters.output.exceptions.enums;

public enum MessageErrors {

    DUPLICATED_ACCOUNT("Conta com CPF/CNPJ ou Email já existente"),
    ACCOUNT_NOT_FOUND("Conta não encontrada"),
    INVALID_ACCOUNT_IDENTIFIER("CPF/CNPJ inváldio");

    public final String description;

    MessageErrors(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
