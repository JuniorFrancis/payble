package com.simple.payble.adapters.output.ports.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.payble.domain.enums.TransactionTypes;

public class EngineMessagePayload {

    TransactionTypes transactionType;

    Object content;

    public EngineMessagePayload(TransactionTypes transactionType, Object content) {
        this.transactionType = transactionType;
        this.content = content;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public JsonNode toJson(){
        return new ObjectMapper().valueToTree(this);
    }
}
