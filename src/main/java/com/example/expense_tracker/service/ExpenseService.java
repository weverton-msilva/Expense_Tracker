package com.example.expense_tracker.service;

import com.example.expense_tracker.dto.ExpenseRequestDTO;
import com.example.expense_tracker.dto.ExpenseResponseDTO;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    // Procurar despesa por data
    public List<Expense> findByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    // Guardar ou atualizar uma despesa
    public ExpenseResponseDTO save(ExpenseRequestDTO dto) {
        Expense expense = new Expense();

        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());
        expense.setDate(dto.date());

        Expense savedExpense = expenseRepository.save(expense);

        return new ExpenseResponseDTO(
                savedExpense.getId(),
                savedExpense.getDescription(),
                savedExpense.getAmount(),
                savedExpense.getDate()
        );
    }

    // Apagar uma despesa por ID
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}
