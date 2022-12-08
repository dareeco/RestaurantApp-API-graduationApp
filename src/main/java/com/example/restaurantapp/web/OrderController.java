package com.example.restaurantapp.web;

import com.example.restaurantapp.model.Order;
import com.example.restaurantapp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOrders(){
        return this.orderService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id){
        return this.orderService.findById(id);
    }

    @PostMapping("/add")
    public Order save(@RequestBody Order order){
        return this.orderService.create(order);
    }

    @PostMapping("/edit/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order){
        return this.orderService.update(id,order);
    }

    @DeleteMapping("/delete/{id}")
    public Order delete(@PathVariable Long id){
        return this.orderService.delete(id);
    }
}
