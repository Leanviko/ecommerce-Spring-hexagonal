package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        if (product.getId()==null){
            User user=new User();
            user.setId(1);//Por ahora le asigno directamente el registro que agregé en la base de datos, despues lo desarrollamos
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
        }else{
            Product productDB = IProductRepository.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());

        }

        return IProductRepository.saveProduct(product);
    }
    public void deleteProductById(Integer id){
        IProductRepository.deleteProductById(id);
    }
}
