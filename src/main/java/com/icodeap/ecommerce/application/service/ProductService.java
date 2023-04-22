package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

public class ProductService {
    private final IProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(IProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Product> getProducts(){
      return productRepository.getProducts();
    }
    public Iterable<Product> getProductsByUser(User user){
        return productRepository.getProductsByUser(user);
    }
    public Product getProductById(Integer id){
        return  productRepository.getProductById(id);
    }
    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId()==null){
            User user=new User();
            user.setId(1);//Por ahora le asigno directamente el registro que agregé en la base de datos, despues lo desarrollamos
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile));
        }else{
            Product productDB = productRepository.getProductById(product.getId());
            if (multipartFile.isEmpty()){
                product.setImage(productDB.getImage());
            }else {
                if (!productDB.getImage().equals("default.jpg")){//elimina la imagen anterior SI NO ES la imagen por defecto
                    uploadFile.delete(productDB.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());

        }

        return productRepository.saveProduct(product);
    }
    public void deleteProductById(Integer id){
        Product productDB = productRepository.getProductById(id);
        if (!productDB.getImage().equals("default.jpg")){//elimina la imagen anterior SI NO ES la imagen por defecto
            uploadFile.delete(productDB.getImage());
        }
        productRepository.deleteProductById(id);

    }
}
