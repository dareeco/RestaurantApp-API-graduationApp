package com.example.restaurantapp.service.implementation;

import com.example.restaurantapp.model.Menu;
import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.model.exceptions.InvalidMenuException;
import com.example.restaurantapp.repository.MenuRepository;
import com.example.restaurantapp.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuImpl implements MenuService {
    private final MenuRepository menuRepository;

    public MenuImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow(InvalidMenuException::new);
    }

    @Override
    public Menu create(List<MenuItem> menuItems) {
        Menu menu=new Menu(menuItems);
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Long id, List<Long> menuItems) {
        return null;
    }

    @Override
    public Menu delete(Long id) {
        return null;
    }
}
