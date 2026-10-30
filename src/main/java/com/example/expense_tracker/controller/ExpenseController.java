package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    // Injeção de dependência via construtor
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Método para listar todas as despesas
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        List<Expense> expenseList = expenseService.findAll();

        return ResponseEntity.ok(expenseList);
    }

    // Método para procurar despesa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.findById(id);

        return expense.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para guardar ou criar uma despesa
    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.save(expense);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

    // Método para Apagar uma despesa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedExpense(@PathVariable Long id) {
        expenseService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
