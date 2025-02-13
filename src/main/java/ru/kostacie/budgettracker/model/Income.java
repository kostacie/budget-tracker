package ru.kostacie.budgettracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount; // Сумма дохода

    @Column(nullable = false)
    private String source; // Источник дохода (зарплата, бонус и т. д.)

    @Column(nullable = false)
    private LocalDateTime dateTime; // Дата и время получения дохода

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // К какому пользователю относится доход
}
