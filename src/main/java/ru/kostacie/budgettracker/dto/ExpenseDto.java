package ru.kostacie.budgettracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ExpenseDto {
    @NotNull(message = "Amount can't be null")
    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Category can't be blank")
    private String categoryName;

    @NotNull(message = "DateTime can't be null")
    private LocalDateTime dateTime;

    @NotNull(message = "User ID can't be null")
    private UUID userId;
}
