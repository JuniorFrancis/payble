package com.simple.payble.adapters.output.ports;

import com.fasterxml.jackson.databind.JsonNode;
import com.simple.payble.adapters.output.ports.models.EngineMessagePayload;
import com.simple.payble.domain.entities.AccountEntity;
import com.simple.payble.domain.enums.TransactionTypes;
import com.simple.payble.ports.output.EngineMessageOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.simple.payble.domain.enums.TransactionTypes.OPENING_ACCOUNT;

@Service
public class EngineMessageOutputPortAdapter implements EngineMessageOutputPort {

    @Autowired
    KafkaTemplate<String, JsonNode> kafkaTemplate;

    @Value("${spring.kafka.producer.topicIn}")
    private String topicIn;

    @Override
    public void publish(TransactionTypes transactionType, AccountEntity accountEntity) {

        kafkaTemplate.send(
                topicIn,
                new EngineMessagePayload(
                    transactionType,
                    accountEntity
                ).toJson()
        );
    }
}
