package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.domain.Order;
import com.icodeap.ecommerce.domain.OrderProduct;
import com.icodeap.ecommerce.infrastructure.entity.OrderEntity;
import com.icodeap.ecommerce.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IOrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer> {
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);
}
