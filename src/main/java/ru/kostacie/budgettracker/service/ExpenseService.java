package ru.kostacie.budgettracker.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostacie.budgettracker.model.Expense;
import ru.kostacie.budgettracker.repository.ExpenseRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public Expense addIncome(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(UUID userId) {
        return expenseRepository.findByUserId(userId);
    }
}
