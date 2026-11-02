package com.example.expense_tracker.repository;

import com.example.expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Buscar despesa pela data
    List<Expense> findByDate(LocalDate date);

    // Buscar despesa pela categoria
    List<Expense> findByCategory(String category);
}
