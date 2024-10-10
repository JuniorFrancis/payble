package com.simple.payble.domain.entities;

import com.simple.payble.adapters.output.repositories.model.AccountModel;
import com.simple.payble.domain.enums.AccountTypes;

public class AccountEntity {

    private Integer accountId;

    private String uniqueIdentifierNumber;

    private boolean status;

    private String email;

    private String name;

    private String lastName;

    private AccountTypes type;

    public AccountEntity(
            String uniqueIdentifierNumber,
            AccountTypes type,
            String email,
            String name,
            String lastName
    ) {
        this.uniqueIdentifierNumber = uniqueIdentifierNumber;
        this.email = email;
        this.type = type;
        this.status = true;
        this.name = name;
        this.lastName = lastName;
    }

    public AccountEntity(
            Integer accountId,
            String uniqueIdentifierNumber,
            boolean status,
            String email,
            String name,
            String lastName,
            AccountTypes type
    ) {
        this.accountId = accountId;
        this.uniqueIdentifierNumber = uniqueIdentifierNumber;
        this.status = status;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.type = type;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public boolean isStatus() {
        return status;
    }

    public String getUniqueIdentifierNumber() {
        return uniqueIdentifierNumber;
    }

    public void setUniqueIdentifierNumber(String uniqueIdentifierNumber) {
        this.uniqueIdentifierNumber = uniqueIdentifierNumber;
    }

    public boolean isActive() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public static AccountEntity toAccountEntity(AccountModel accountModel){
        return new AccountEntity(
                accountModel.getId(),
                accountModel.getUniqueIdentifierNumber(),
                accountModel.isActive(),
                accountModel.getEmail(),
                accountModel.getLastName(),
                accountModel.getName(),
                accountModel.getType()
        );
    }
}
