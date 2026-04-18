package com.vinicius.financeaiapi.controller;

import com.vinicius.financeaiapi.model.Expense;
import com.vinicius.financeaiapi.repository.ExpenseRepository;
import com.vinicius.financeaiapi.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseRepository repository;
    private final ExpenseService service;

    public ExpenseController(ExpenseRepository repository, ExpenseService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public Expense create(@RequestBody @Valid Expense expense) {

        String category = service.classify(expense.getDescription());
        expense.setCategory(category);

        return repository.save(expense);
    }

    @GetMapping
    public List<Expense> list() {
        return repository.findAll();
    }
}