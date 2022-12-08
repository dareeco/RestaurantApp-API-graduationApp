package com.example.restaurantapp.model.exceptions;

public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException(){
        super(String.format("Order with that particular id is not found"));

    }
}