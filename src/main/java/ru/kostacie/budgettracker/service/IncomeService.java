package ru.kostacie.budgettracker.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostacie.budgettracker.model.Income;
import ru.kostacie.budgettracker.model.User;
import ru.kostacie.budgettracker.repository.IncomeRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getUserIncomes(UUID userId) {
        return incomeRepository.findByUserId(userId);
    }
}
