package ru.kostacie.budgettracker.model;

import jakarta.persistence.*;
import ru.kostacie.budgettracker.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount; // Сумма расхода

    @Column(nullable = false)
    private String category; // Категория расхода (еда, транспорт и т. д.)

    @Column(nullable = false)
    private LocalDateTime dateTime; // Дата и время расхода

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // К какому пользователю относится расход
}
