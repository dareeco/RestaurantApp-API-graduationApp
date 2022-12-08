package com.example.restaurantapp.model.exceptions;

public class InvalidMenuException extends RuntimeException{
    public  InvalidMenuException(){
        super(String.format("Menu Item is not found"));
    }
}
