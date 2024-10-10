package com.simple.payble.controllers;

import com.simple.payble.adapters.inbound.models.AccountRequest;
import com.simple.payble.adapters.inbound.models.DeactivateAccount;
import com.simple.payble.domain.entities.AccountEntity;
import com.simple.payble.domain.usecases.interfaces.AccountManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountManagerUseCase accountManagerUseCase;

    @Autowired
    public AccountController(AccountManagerUseCase accountManagerUseCase) {
        this.accountManagerUseCase = accountManagerUseCase;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AccountRequest accountRequest) throws Exception {
        accountManagerUseCase.creatingAccount(
                new AccountEntity(
                        accountRequest.uniqueIdentifierNumber(),
                        accountRequest.type(),
                        accountRequest.email(),
                        accountRequest.name(),
                        accountRequest.lastname()
                )
        );
    }

    @PatchMapping("/deactivate/{cpfcnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(
            @PathVariable("cpfcnpj") String uniqueIdentifierNumber,
            @RequestBody DeactivateAccount deactivateAccount
    ) {

        if(!deactivateAccount.status()){
            accountManagerUseCase.deactivateAccount(uniqueIdentifierNumber);
        }
    }
}
