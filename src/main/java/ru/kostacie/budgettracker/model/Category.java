package ru.kostacie.budgettracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.kostacie.budgettracker.model.enums.CategoryType;

@Entity
@Table(name = "categories")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    private String name; // Продукты, Развлечения, Транспорт

    @Enumerated(EnumType.STRING)
    private CategoryType type; // INCOME или EXPENSE
}

