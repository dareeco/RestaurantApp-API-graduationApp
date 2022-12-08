package com.example.restaurantapp.service.implementation;

import com.example.restaurantapp.model.Order;
import com.example.restaurantapp.model.exceptions.InvalidOrderException;
import com.example.restaurantapp.repository.OrderRepository;
import com.example.restaurantapp.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
      return orderRepository.save(order);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Long id, Order order) {
        Order order1=this.orderRepository.findById(id).orElseThrow(InvalidOrderException::new);
        order1.setOrderType(order.getOrderType());
        order1.setOrderSpecificName(order.getOrderSpecificName());
        order1.setQuantity(order.getQuantity());
        order1.setQuantityType(order.getQuantityType());
        return orderRepository.save(order1);
    }

    @Override
    public Order delete(Long id) {
        Order order=this.orderRepository.findById(id).orElseThrow(InvalidOrderException::new);
        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
