package com.vinicius.financeaiapi.service;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final OpenAIService ai;

    public ExpenseService(OpenAIService ai) {
        this.ai = ai;
    }

    public String classify(String description) {
        return ai.classify(description);
    }
}