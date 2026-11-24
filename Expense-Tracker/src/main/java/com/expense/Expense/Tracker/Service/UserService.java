package com.expense.Expense.Tracker.Service;

import com.expense.Expense.Tracker.Repository.UserRepository;
import com.expense.Expense.Tracker.models.ExpenseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ExpenseUser createUser(ExpenseUser user){
        return userRepository.save(user);
    }

    public ExpenseUser getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }
}
