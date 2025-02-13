package ru.kostacie.budgettracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostacie.budgettracker.model.Expense;
import ru.kostacie.budgettracker.service.ExpenseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.addIncome(expense));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable UUID userId) {
        return ResponseEntity.ok(expenseService.getUserExpenses(userId));
    }
}
