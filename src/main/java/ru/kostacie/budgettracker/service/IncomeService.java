package ru.kostacie.budgettracker.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostacie.budgettracker.dto.IncomeDto;
import ru.kostacie.budgettracker.model.Category;
import ru.kostacie.budgettracker.model.Income;
import ru.kostacie.budgettracker.model.User;
import ru.kostacie.budgettracker.model.enums.CategoryType;
import ru.kostacie.budgettracker.repository.IncomeRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserService userService;

    public Income addIncome(IncomeDto request) {
        try {
            UUID userId = request.getUserId();
            //TODO: Implement custom exception
            User user = userService.getUserById(userId).orElseThrow(() -> new Exception("User not found."));
            Category category = getCategory(request);
            Income income = Income.builder()
                    .amount(request.getAmount())
                    .dateTime(request.getDateTime())
                    .user(user)
                    .category(category)
                    .build();
            return incomeRepository.save(income);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Income> getUserIncomes(UUID userId) {
        return incomeRepository.findByUserId(userId);
    }

    private static Category getCategory(IncomeDto request) {
        return Category.builder()
                .name(request.getCategoryName())
                .type(CategoryType.INCOME)
                .build();
    }
}
