package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IOrderRepository;
import com.icodeap.ecommerce.domain.Order;

public class OrderService {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order createOrder(Order order){
        return orderRepository.createOrder(order);
    }
    public Iterable<Order> getOrders(){
        return orderRepository.getOrders();
    }
}
