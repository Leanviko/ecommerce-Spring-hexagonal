package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.application.repository.IProductRepository;
import com.icodeap.ecommerce.application.repository.IStockRepository;
import com.icodeap.ecommerce.application.service.ProductService;
import com.icodeap.ecommerce.application.service.StockService;
import com.icodeap.ecommerce.application.service.UploadFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(IProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }
    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public StockService stockService(IStockRepository stockRepository){
        return new StockService(stockRepository);
    }
}
