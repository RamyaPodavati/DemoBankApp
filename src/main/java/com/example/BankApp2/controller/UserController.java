package com.example.BankApp2.controller;

import com.example.BankApp2.exceptions.UserNotFoundException;
import com.example.BankApp2.model.User;
import com.example.BankApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   UserService userService;

   @GetMapping()
   public List<User> getUsers(){
      return userService.getAllUsers();
   }
   @GetMapping("/{id}")
   //public User getUserswithID(@RequestParam (name = "id2", required= false) int id, @RequestParam(name = "userName") String username)
   public User getUserswithID(@PathVariable("id") int id ){
      return userService.getUserwithID(id);
   }
   @PostMapping
   public User createNewUser(@RequestBody User user){
           userService.saveUser(user);
           return user;
   }
   @PutMapping("/{id}")
   public User updateUser(@PathVariable int id, @RequestBody User user ) throws UserNotFoundException {

      userService.updateUser(user, id);
      return user;
   }
   @DeleteMapping("/{id}")
   private void deleteStudent(@PathVariable("id") int id)
   {
      userService.deleteUser(id);
   }

   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<String> handleException(UserNotFoundException rte) {
      rte.printStackTrace();
      return new ResponseEntity<>("User not exist for the given input " + rte.getLocalizedMessage(), HttpStatus.NOT_FOUND);
   }


}
