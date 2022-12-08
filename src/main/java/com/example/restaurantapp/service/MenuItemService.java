package com.example.restaurantapp.service;

import com.example.restaurantapp.model.MenuItem;

import java.util.List;
import java.util.Optional;

public interface MenuItemService {
    Optional<MenuItem> findById(Long id);

    MenuItem findByName(String name);


    List<MenuItem> listAll();

   //MenuItem create(String name, String description, float price);
    MenuItem create(MenuItem menuItem);

    MenuItem update(Long id, MenuItem menuItem);

    MenuItem delete(Long id);
}
