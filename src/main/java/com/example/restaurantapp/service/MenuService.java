package com.example.restaurantapp.service;

import com.example.restaurantapp.model.Menu;
import com.example.restaurantapp.model.MenuItem;

import java.util.List;

public interface MenuService {
    Menu findById(Long id);

    Menu create(List<MenuItem> menuItems);

    Menu update(Long id, List<Long> menuItems);

    Menu delete(Long id);

}
