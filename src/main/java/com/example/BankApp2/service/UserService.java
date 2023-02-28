package com.example.BankApp2.service;

import com.example.BankApp2.exceptions.UserNotFoundException;
import com.example.BankApp2.model.User;
import com.example.BankApp2.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    //getting all student records
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserwithID(Integer id){
        return userRepository.findById(id).get();
    }

    public User getStudentById(int id)
    {

        return userRepository.findById(id).get();
    }
    public void saveUser(User user)
    {
        userRepository.save(user);
    }
    //deleting a specific record
    public void updateUser(User user, int id) throws UserNotFoundException
    {
        User userfromDB = userRepository.findById(id).orElseThrow(()->{
            return new UserNotFoundException(id + " doesn't exist");
        });
        user.setId(id);
        userRepository.save(user);
    }
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }
}
