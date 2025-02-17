package ru.kostacie.budgettracker.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostacie.budgettracker.dto.ExpenseDto;
import ru.kostacie.budgettracker.dto.IncomeDto;
import ru.kostacie.budgettracker.model.Category;
import ru.kostacie.budgettracker.model.Expense;
import ru.kostacie.budgettracker.model.Income;
import ru.kostacie.budgettracker.model.User;
import ru.kostacie.budgettracker.model.enums.CategoryType;
import ru.kostacie.budgettracker.repository.ExpenseRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public Expense addExpense(ExpenseDto request) {
        try {
            UUID userId = request.getUserId();
            //TODO: Implement custom exception
            User user = userService.getUserById(userId).orElseThrow(() -> new Exception("User not found."));
            Category category = getCategory(request);
            Expense expense = Expense.builder()
                    .amount(request.getAmount())
                    .dateTime(request.getDateTime())
                    .user(user)
                    .category(category)
                    .build();
            return expenseRepository.save(expense);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Expense> getUserExpenses(UUID userId) {
        return expenseRepository.findByUserId(userId);
    }

    private static Category getCategory(ExpenseDto request) {
        return Category.builder()
                .name(request.getCategoryName())
                .type(CategoryType.INCOME)
                .build();
    }
}
