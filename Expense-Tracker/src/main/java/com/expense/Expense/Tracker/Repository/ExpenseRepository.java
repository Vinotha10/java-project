package com.expense.Expense.Tracker.Repository;


import com.expense.Expense.Tracker.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Item, Long> {
}
