package com.simple.payble.adapters.output.repositories.model;

import com.simple.payble.domain.enums.AccountTypes;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_clients")
public class AccountModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "cpf_cnpj")
    private String uniqueIdentifierNumber;

    private boolean status;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private AccountTypes type;

    @Column( name = "created_at")
    private LocalDateTime createdAt;

    @Column( name = "updated_at")
    private LocalDateTime updatedAt;

    public AccountModel() {
    }

    public AccountModel(int id, String uniqueIdentifierNumber, boolean status, String name, String lastName, String email, AccountTypes type, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uniqueIdentifierNumber = uniqueIdentifierNumber;
        this.status = status;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AccountModel(
            String uniqueIdentifierNumber,
            boolean status,
            AccountTypes type,
            LocalDateTime createdAt,
            String email,
            String name,
            String lastName
    ) {
        this.uniqueIdentifierNumber = uniqueIdentifierNumber;
        this.status = status;
        this.type = type;
        this.email = email;
        this.createdAt = createdAt;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
