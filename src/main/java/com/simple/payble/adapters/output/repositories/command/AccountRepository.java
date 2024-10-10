package com.simple.payble.adapters.output.repositories.command;

import com.simple.payble.adapters.output.repositories.model.AccountModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends Repository<AccountModel, Integer> {

    AccountModel save(AccountModel accountModel);

    Optional<AccountModel> findByUniqueIdentifierNumber(String uniqueIdentifierNumber);

    @Modifying
    @Query("update AccountModel u set u.status = false where u.uniqueIdentifierNumber = :uniqueIdentifierNumber")
    void deactivateAccount(@Param("uniqueIdentifierNumber") String uniqueIdentifierNumber);
}

