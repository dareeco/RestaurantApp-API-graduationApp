package com.example.restaurantapp.service;

import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.model.Table;

import java.util.List;
import java.util.Optional;

public interface TableService {

    List<Table> listAll();
    Optional<Table> findById(Long Id);
    //We don't need list all because the tables will be fixed on positions
    Table create(Table table);

    Table update(Long id, Table table); //Maybe we'll need this
    Table delete(Long id);
    //Add functions for adding, removing menuItems, calculating total sum!!!!
    List<MenuItem> addMenuItem(long id, String name);
    List<MenuItem> listAllMenuItemsForGivenTable(long id);
    Table clearTable(long id);
}
