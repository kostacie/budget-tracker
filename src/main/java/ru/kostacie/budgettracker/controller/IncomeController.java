package ru.kostacie.budgettracker.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostacie.budgettracker.dto.IncomeDto;
import ru.kostacie.budgettracker.model.Income;
import ru.kostacie.budgettracker.service.IncomeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@Tag(name = "Доходы", description = "API для управления доходами")
public class IncomeController {
    private final IncomeService incomeService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Income>> getUserIncomes(@PathVariable UUID userId) {
        List<Income> userIncomes = incomeService.getUserIncomes(userId);
        return ResponseEntity.ok(userIncomes);
    }

    //FIXME: Category can't be saved to Income
    @PostMapping
    public ResponseEntity<Income> addIncome(@Valid @RequestBody IncomeDto request){
        Income income = incomeService.addIncome(request);
        return ResponseEntity.ok(income);
    }
}