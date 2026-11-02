package com.example.expense_tracker.service;

import com.example.expense_tracker.dto.ExpenseRequestDTO;
import com.example.expense_tracker.dto.ExpenseResponseDTO;
import com.example.expense_tracker.exception.ExpenseNotFoundException;
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
    public List<ExpenseResponseDTO> findAll() {
        return expenseRepository.findAll()
                .stream().map(expense -> new ExpenseResponseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate()
                )).toList();
    }
    // Procurar despesa por ID
    public ExpenseResponseDTO findById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(
                        "Expense not found with id: " + id
                ));

        return new ExpenseResponseDTO(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getDate()
        );
    }

    // Procurar despesa por data
    public List<ExpenseResponseDTO> findByDate(LocalDate date) {
        return expenseRepository.findByDate(date)
                .stream().map(expense -> new ExpenseResponseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate()
                )).toList();
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

        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found");
        }

        expenseRepository.deleteById(id);
    }
}
