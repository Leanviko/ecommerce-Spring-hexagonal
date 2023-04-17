package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity,Integer> {
}
