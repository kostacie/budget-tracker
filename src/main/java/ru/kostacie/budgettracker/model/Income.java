package ru.kostacie.budgettracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "incomes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Income extends AbstractPersistable<Long> {

    @Column(nullable = false)
    private BigDecimal amount; // Сумма дохода

//    @Column(nullable = false)
//    private String source; // Источник дохода (зарплата, бонус и т.д.)

    @Column(nullable = false)
    private LocalDateTime dateTime; // Дата и время получения дохода

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // К какому пользователю относится доход

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
