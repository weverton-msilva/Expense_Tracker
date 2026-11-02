package com.example.expense_tracker.controller;

import com.example.expense_tracker.dto.ExpenseRequestDTO;
import com.example.expense_tracker.dto.ExpenseResponseDTO;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses() {
        List<ExpenseResponseDTO> expenseList = expenseService.findAll();

        return ResponseEntity.ok(expenseList);
    }

    // Método para procurar despesa por ID
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDTO> getExpenseById(@PathVariable Long id) {
        ExpenseResponseDTO expense = expenseService.findById(id);

        return ResponseEntity.ok(expense);
    }

    // Método para procurar despesa pela data
    @GetMapping("/date/{date}")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenseByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        List<ExpenseResponseDTO> expenses = expenseService.findByDate(date);

        return ResponseEntity.ok(expenses);
    }

    // Método para guardar ou criar uma despesa
    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> saveExpense(@Valid @RequestBody ExpenseRequestDTO dto) {
        ExpenseResponseDTO savedExpense = expenseService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

    // Método para Apagar uma despesa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedExpense(@PathVariable Long id) {
        expenseService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
