package com.example.BankApp2.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException( String message){
        super(message);
    }
}
