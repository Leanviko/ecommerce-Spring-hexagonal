package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IOrderProductRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final IOrderProductRepository orderProductRepository;

    public OrderProductService(IOrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct){
      return  orderProductRepository.create(orderProduct);
    }
    public Iterable<OrderProduct> getOrderProducts(){
     return orderProductRepository.getOrderProducts();
    }
    public List<OrderProduct> getOrdersProductByOrder(Order order){
        return orderProductRepository.getOrdersProductByOrder(order);
    }
}
