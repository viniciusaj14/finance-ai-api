package com.vinicius.financeaiapi.service;

import com.vinicius.financeaiapi.model.Expense;
import com.vinicius.financeaiapi.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;
    private final OpenAIService ai;

    public ExpenseService(ExpenseRepository repository, OpenAIService ai) {
        this.repository = repository;
        this.ai = ai;
    }

    public Expense create(Expense expense) {

        // 🔥 IA classificando
        String categoria = ai.classify(expense.getDescription());

        expense.setCategory(categoria);

        // 💾 salva no banco
        return repository.save(expense);
    }
}