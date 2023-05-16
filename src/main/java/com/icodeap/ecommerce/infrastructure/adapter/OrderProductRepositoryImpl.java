package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.IOrderProductRepository;
import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.OrderProduct;
import com.icodeap.ecommerce.infrastructure.mapper.IOrderMapper;
import com.icodeap.ecommerce.infrastructure.mapper.IOrderProductMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderProductRepositoryImpl implements IOrderProductRepository {
    private final IOrderProductCrudRepository orderProductCrudRepository;
    private final IOrderMapper orderMapper;
    private final IOrderProductMapper orderProductMapper;

    public OrderProductRepositoryImpl(IOrderProductCrudRepository orderProductCrudRepository, IOrderMapper orderMapper, IOrderProductMapper orderProductMapper) {
        this.orderProductCrudRepository = orderProductCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }


    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct(orderProductCrudRepository.save(orderProductMapper.toOrderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts(orderProductCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrdersProductByOrder(Order order) {
        return orderProductMapper.toOrderProductsList(orderProductCrudRepository.findByPkOrderEntity(orderMapper.toOrderEntity(order)));
    }
}
