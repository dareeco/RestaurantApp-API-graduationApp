package com.example.restaurantapp.web;

import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.service.MenuItemService;
import com.example.restaurantapp.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;
    private final MenuItemService menuItemService;

    public MenuController(MenuService menuService, MenuItemService menuItemService) {
        this.menuService = menuService;
        this.menuItemService = menuItemService;
    }
    @GetMapping
    public List<MenuItem> findAll(){
        return this.menuItemService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<MenuItem> findById(@PathVariable Long id){
        return  this.menuItemService.findById(id);
    }

//    @GetMapping("/{name}")
//    //CREATES Ambiguous handler methods mapped for  RESOLVE IT TRY WITH REQUEST PARAMS OR CHANGE THE PATH
//    //works with http://localhost:9999/api/menu/?name=Whiskey
//    public MenuItem findByName(@PathVariable String name){
//        return  this.menuItemService.findByName(name);
//    }


    @PostMapping("/add")
    public MenuItem save(@RequestBody MenuItem menuItem) {
        return this.menuItemService.create(menuItem);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.menuItemService.delete(id);
        if(this.menuItemService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/edit/{id}")
    public MenuItem edit(@PathVariable Long id, @RequestBody MenuItem menuItem){
        return this.menuItemService.update(id,menuItem);
    }
}
