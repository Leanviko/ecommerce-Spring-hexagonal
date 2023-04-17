package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;


public class ProductService {
    private final IProductRepository IProductRepository;

    public ProductService(IProductRepository IProductRepository) {
        this.IProductRepository = IProductRepository;
    }

    public Iterable<Product> getProducts(){
      return IProductRepository.getProducts();
    }
    public Iterable<Product> getProductsByUser(User user){
        return IProductRepository.getProductsByUser(user);
    }
    public Product getProductById(Integer id){
        return  IProductRepository.getProductById(id);
    }
    public Product saveProduct(Product product){
        return IProductRepository.saveProduct(product);
    }
    public void deleteProductById(Integer id){
        IProductRepository.deleteProductById(id);
    }
}
