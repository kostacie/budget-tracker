package ru.kostacie.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostacie.budgettracker.model.Expense;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(UUID userId);
}
