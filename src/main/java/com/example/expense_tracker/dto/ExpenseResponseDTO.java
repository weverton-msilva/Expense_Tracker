package com.example.expense_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        LocalDate date,
        String category
) {}
