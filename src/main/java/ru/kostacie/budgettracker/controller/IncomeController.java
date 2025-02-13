package ru.kostacie.budgettracker.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostacie.budgettracker.model.Income;
import ru.kostacie.budgettracker.service.IncomeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Income>> getUserIncomes(@PathVariable UUID userId) {
        return ResponseEntity.ok(incomeService.getUserIncomes(userId));
    }

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income){
        return ResponseEntity.ok(incomeService.addIncome(income));
    }
}