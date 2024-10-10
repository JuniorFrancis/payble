package com.simple.payble.ports.output;

import com.simple.payble.domain.entities.AccountEntity;
import com.simple.payble.domain.enums.TransactionTypes;

public interface EngineMessageOutputPort {

    void publish(TransactionTypes transactionTypes, AccountEntity accountEntity);
}
