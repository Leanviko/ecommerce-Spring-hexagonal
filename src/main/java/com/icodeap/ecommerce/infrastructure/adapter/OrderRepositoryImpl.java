package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.IOrderRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.infrastructure.mapper.IOrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {

    private final IOrderCrudRepository orderCrudRepository;
    private final IOrderMapper orderMapper;

    public OrderRepositoryImpl(IOrderCrudRepository orderCrudRepository, IOrderMapper orderMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }
}
