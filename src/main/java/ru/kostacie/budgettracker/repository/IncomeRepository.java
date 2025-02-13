package ru.kostacie.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kostacie.budgettracker.model.Income;

import java.util.List;
import java.util.UUID;


@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(UUID userId);
}
