package com.example.restaurantapp.service;
import com.example.restaurantapp.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order create(Order order);
    List<Order> listAll();
    Order update(Long id,Order order);
    Order delete(Long id);

    Optional<Order> findById(Long id);
}
