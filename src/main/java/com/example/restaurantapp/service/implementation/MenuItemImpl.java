package com.example.restaurantapp.service.implementation;

import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.model.exceptions.InvalidMenuException;
import com.example.restaurantapp.model.exceptions.InvalidMenuItemIdException;
import com.example.restaurantapp.repository.MenuItemRepository;
import com.example.restaurantapp.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemImpl implements MenuItemService {
   private final MenuItemRepository menuItemRepository;

    public MenuItemImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Optional<MenuItem> findById(Long id) {
        //return menuItemRepository.findById(id).orElseThrow(InvalidMenuItemIdException::new);
        return menuItemRepository.findById(id);
    }

    @Override
    public MenuItem findByName(String name) {
        return menuItemRepository.findByName(name).orElseThrow(() -> new InvalidMenuException());
    }

    @Override
    public List<MenuItem> listAll() {
        return menuItemRepository.findAll();
    }

//    @Override
//    public MenuItem create(String name, String description, float price) {
//        MenuItem menuItem=new MenuItem(name,description,price);
//        return menuItemRepository.save(menuItem);
//    }
    @Override
    public MenuItem create(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem update(Long id, MenuItem menuItem){
        MenuItem menuItem1=menuItemRepository.findById(id).orElseThrow(InvalidMenuItemIdException::new);
        menuItem1.setPrice(menuItem.getPrice());
        menuItem1.setDescription(menuItem.getDescription());
        menuItem1.setName(menuItem.getName());
        return menuItemRepository.save(menuItem1); //Try this.menuItemRepository.save(menuItem) if this doesn't work
    }


    @Override
    public MenuItem delete(Long id) {
        MenuItem menuItem=this.menuItemRepository.findById(id).orElseThrow(InvalidMenuItemIdException::new);
        menuItemRepository.deleteById(id);
        return menuItem;
    }
}
