package com.example.restaurantapp.model.exceptions;

public class InvalidMenuItemIdException extends RuntimeException {
    public  InvalidMenuItemIdException(){
        super(String.format("Menu Item is not found"));
    }
}
