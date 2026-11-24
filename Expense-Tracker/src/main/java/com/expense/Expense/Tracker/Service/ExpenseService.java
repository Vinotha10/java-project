package com.expense.Expense.Tracker.Service;

import com.expense.Expense.Tracker.Repository.ExpenseRepository;
import com.expense.Expense.Tracker.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    public ExpenseRepository expenseRepository;

    public Item createItem(Item todo){
        return expenseRepository.save(todo);
    }

    public Item getExpenseById(Long id){
        return expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public List<Item> getExpenses() {
        return expenseRepository.findAll();
    }

    public Page<Item> getAllTodosPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return expenseRepository.findAll(pageable);
    }

    public Item updateExpense(Long id, Item item) {
        Item existingItem = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existingItem.setTitle(item.getTitle());
        existingItem.setExpense(item.getExpense());
        existingItem.setDate(item.getDate());

        return expenseRepository.save(existingItem);
    }

    public void deleteExpenseById(Long id){
        expenseRepository.delete(getExpenseById(id));
    }

}
