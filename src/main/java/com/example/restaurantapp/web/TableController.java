package com.example.restaurantapp.web;

import com.example.restaurantapp.model.MenuItem;
import com.example.restaurantapp.model.Table;
import com.example.restaurantapp.model.exceptions.InvalidTableException;
import com.example.restaurantapp.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public List<Table> findAllTables(){
        return this.tableService.listAll();
    }

    @GetMapping("/{id}/menuItems")
    public List<MenuItem> findAllMenuItemsForTable(@PathVariable long id){
        return this.tableService.listAllMenuItemsForGivenTable(id);
    }

    @GetMapping("/{id}")
    public Optional<Table> findById(@PathVariable Long id){ return this.tableService.findById(id);}

    @PostMapping("/add")
    public Table save(@RequestBody Table table){
        return this.tableService.create(table);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.tableService.delete(id);
        if(this.tableService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public Table edit(@PathVariable Long id, @RequestBody Table table){
        return this.tableService.update(id,table);
    }

    //Create the tableItems from Postman with name in Params!!! on path http://localhost:9999/api/table/add/menuitem/id
    @PostMapping("/add/menuItems/{id}")
    public List<MenuItem> addMenuItem(@PathVariable long id, @RequestParam String name){
        return this.tableService.addMenuItem(id,name);
    }

    @GetMapping("/clear/{id}")
    public Table clear(@PathVariable long id){
        return this.tableService.clearTable(id);
    }

}
