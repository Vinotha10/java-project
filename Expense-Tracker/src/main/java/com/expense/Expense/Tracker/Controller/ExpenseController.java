package com.expense.Expense.Tracker.Controller;

import com.expense.Expense.Tracker.Service.ExpenseService;
import com.expense.Expense.Tracker.models.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
@Slf4j
public class ExpenseController {
    @Autowired
    public ExpenseService expenseService;

    @GetMapping("/{id}")
    ResponseEntity<Item> getExpenseById(@PathVariable Long id) {
        try{
            Item getTodo = expenseService.getExpenseById(id);
            return new ResponseEntity<>(getTodo, HttpStatus.OK);
        } catch (RuntimeException exception){
            log.error("", exception);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get")
    ResponseEntity<List<Item>> getExpense(){
        List<Item> expense = expenseService.getExpenses();
        return new ResponseEntity<List<Item>>(expense, HttpStatus.OK );
    }

    @PostMapping("/create")
    ResponseEntity<Item> createExpense(@RequestBody Item item){
        Item createItem = expenseService.createItem(item);
        return new ResponseEntity<>(createItem, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item){
        return new ResponseEntity<>(expenseService.updateExpense(id, item), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    void deleteItemById(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
    }
}
