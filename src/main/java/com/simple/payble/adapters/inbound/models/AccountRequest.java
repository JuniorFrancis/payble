package com.simple.payble.adapters.inbound.models;

import com.simple.payble.domain.enums.AccountTypes;

public record AccountRequest(
        String uniqueIdentifierNumber,
        String email,
        AccountTypes type,
        String name,
        String lastname

) {
}
