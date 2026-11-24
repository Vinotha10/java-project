package com.expense.Expense.Tracker.Repository;

import com.expense.Expense.Tracker.models.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ExpenseUser, Long> {
    Optional<ExpenseUser> findByEmail(String email);
}
