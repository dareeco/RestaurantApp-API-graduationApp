package com.example.restaurantapp.service.implementation;

import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.model.Table;
import com.example.restaurantapp.model.exceptions.InvalidMenuException;
import com.example.restaurantapp.model.exceptions.InvalidMenuItemIdException;
import com.example.restaurantapp.model.exceptions.InvalidTableException;
import com.example.restaurantapp.repository.MenuItemRepository;
import com.example.restaurantapp.repository.TableRepository;
import com.example.restaurantapp.service.MenuItemService;
import com.example.restaurantapp.service.TableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableImpl implements TableService {

    private final TableRepository tableRepository;
    private final MenuItemRepository menuItemRepository;

    public TableImpl(TableRepository tableRepository, MenuItemRepository menuItemRepository) {
        this.tableRepository = tableRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<Table> listAll(){
        return tableRepository.findAll();
    }
    @Override
    public Optional<Table> findById(Long Id) {
        return tableRepository.findById(Id);
    }

    @Override
    public Table create(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public Table update(Long id, Table table) {
        Table table1=this.tableRepository.findById(id).orElseThrow(InvalidTableException::new);
        table1.setTableName(table.getTableName());
        table1.setMenuItems(table.getMenuItems());

        return tableRepository.save(table1);
    }

    @Override
    public Table delete(Long id) {
        Table table=this.tableRepository.findById(id).orElseThrow(InvalidTableException::new);
        tableRepository.deleteById(id);
        return table;
    }

    @Override
    public List<MenuItem> addMenuItem(long id, String name) {
        MenuItem menuItem=menuItemRepository.findByName(name).orElseThrow(InvalidMenuItemIdException:: new);
        Table table = this.findById(id).orElseThrow(InvalidTableException:: new);
        List<MenuItem> menuItems = table.getMenuItems();
        menuItems.add(menuItem);
        table.setMenuItems(menuItems);
        float updatedTotalSum=table.getTotalSum();
        updatedTotalSum+= menuItem.getPrice();
        table.setTotalSum(updatedTotalSum);
        this.tableRepository.save(table);
        //Add list
        return menuItems;
    }

    @Override
    public List<MenuItem> listAllMenuItemsForGivenTable(long id) {
        Table table=this.tableRepository.findById(id).orElseThrow(InvalidTableException::new);
        return  table.getMenuItems();
    }

    @Override
    public Table clearTable(long id) {
        Table table = this.findById(id).orElseThrow(InvalidTableException:: new);
        List<MenuItem> cleared=new ArrayList<>();
        table.setMenuItems(cleared);
        float clearedTotalSum=0;
        table.setTotalSum(clearedTotalSum);
        this.tableRepository.save(table);
        return table;
    }
}
