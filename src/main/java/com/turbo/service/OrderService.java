package com.turbo.service;

import com.turbo.model.*;
import com.turbo.repository.OrderRepository;
import com.turbo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private StatusRepository statusRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }


    public Order createNewOrder(Turbocharger turbocharger, List<Part> parts, Reason reason) {
        Order order = new Order(turbocharger, parts, reason);
        order.setOrderDate(LocalDate.now());

        Optional<Status> statusOptional = statusRepository.findById(1);
        if (statusOptional.isPresent()) {
            Status status = statusOptional.get();
            order.setStatus(status);
        }

        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
