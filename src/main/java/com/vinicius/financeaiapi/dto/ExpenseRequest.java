package com.vinicius.financeaiapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExpenseRequest {

    @NotBlank
    private String description;

    @NotNull
    private Double amount;

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}