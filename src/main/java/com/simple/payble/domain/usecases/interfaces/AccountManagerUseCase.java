package com.simple.payble.domain.usecases.interfaces;

import com.simple.payble.domain.entities.AccountEntity;

public interface AccountManagerUseCase {

    void creatingAccount(AccountEntity account) throws Exception;

    void deactivateAccount(String uniqueIdentifierNumber);

}
