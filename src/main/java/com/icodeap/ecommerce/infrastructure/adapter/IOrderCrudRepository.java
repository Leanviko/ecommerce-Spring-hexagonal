package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;


public interface IOrderCrudRepository extends CrudRepository<OrderEntity,Integer> {

}
