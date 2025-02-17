package ru.kostacie.budgettracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "expenses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense extends AbstractPersistable<Long> {

    @Column(nullable = false)
    private BigDecimal amount; // Сумма расхода

//    @Column(nullable = false)
//    private String source; // Категория расхода (продукты, транспорт и т. д.)

    @Column(nullable = false)
    private LocalDateTime dateTime; // Дата и время расхода

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // К какому пользователю относится расход

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
