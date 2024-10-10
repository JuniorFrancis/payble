package com.simple.payble.ports.output;

import com.simple.payble.domain.entities.AccountEntity;

public interface AccountOutputPort {

    Integer createAccount(AccountEntity accountEntity);

    void deactivateAccount(AccountEntity account);

    AccountEntity findAccountByUniqueIdentifierNumber(String uniqueIdentifierNumber);
}
