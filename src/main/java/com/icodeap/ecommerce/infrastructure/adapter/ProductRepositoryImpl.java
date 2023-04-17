package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository productCrudRepository;

    public ProductRepositoryImpl(IProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return null;
    }

    @Override
    public Iterable<Product> getProductsByUser(User user) {
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Integer id) {

    }
}
