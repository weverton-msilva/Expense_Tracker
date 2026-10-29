package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    // Injeção de dependência via construtor
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Listar todas as despesas
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // Procurar despesa por ID
    public Optional<Expense> findById(Long id) {
        return expenseRepository.findById(id);
    }

    // Guardar ou atualizar uma despesa
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Apagar uma despesa por ID
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}
