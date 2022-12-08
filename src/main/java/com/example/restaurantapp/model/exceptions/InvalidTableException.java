package com.example.restaurantapp.model.exceptions;

public class InvalidTableException extends RuntimeException{
    public InvalidTableException(){
        super(String.format("Table with that particular id is not found"));

    }
}
