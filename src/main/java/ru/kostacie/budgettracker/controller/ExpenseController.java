package ru.kostacie.budgettracker.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostacie.budgettracker.dto.ExpenseDto;
import ru.kostacie.budgettracker.model.Expense;
import ru.kostacie.budgettracker.service.ExpenseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@Tag(name = "Расходы", description = "API для управления расходами")
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable UUID userId) {
        List<Expense> userExpenses = expenseService.getUserExpenses(userId);
        return ResponseEntity.ok(userExpenses);
    }

    //FIXME: Category can't be saved to Expense
    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody ExpenseDto expenseDto) {
        Expense expense = expenseService.addExpense(expenseDto);
        return ResponseEntity.ok(expense);
    }
}
