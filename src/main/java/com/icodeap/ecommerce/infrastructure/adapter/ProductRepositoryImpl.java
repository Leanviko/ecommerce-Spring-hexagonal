package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.infrastructure.mapper.IProductMapper;
import com.icodeap.ecommerce.infrastructure.mapper.IUserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository productCrudRepository;
    private final IProductMapper productMapper;
    private final IUserMapper userMapper;

    public ProductRepositoryImpl(IProductCrudRepository productCrudRepository, IProductMapper productMapper, IUserMapper userMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Iterable<Product> getProducts() {
        //ProductCrud recibe un productEntity y el mapper lo pasa a Product
        return productMapper.toProducts(productCrudRepository.findAll());

    }

    @Override
    public Iterable<Product> getProductsByUser(User user) {

        return productMapper.toProducts(productCrudRepository.findByUserEntity(userMapper.toUserEntity(user)));
    }

    @Override
    public Product getProductById(Integer id) {

        return productMapper.toProduct(productCrudRepository.findById(id).get());
    }

    @Override
    public Product saveProduct(Product product) {

        return productMapper.toProduct(productCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public void deleteProductById(Integer id) {
    productCrudRepository.deleteById(id);
    }
}
