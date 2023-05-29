package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.application.repository.*;
import com.icodeap.ecommerce.application.service.*;
import com.icodeap.ecommerce.infrastructure.adapter.OrderRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

import java.beans.BeanProperty;

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

    @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
    }

    @Bean
    public OrderService orderService(IOrderRepository orderRepository){
        return new OrderService(orderRepository);
    }

    @Bean
    public OrderProductService orderProductService(IOrderProductRepository orderProductRepository){
        return new OrderProductService(orderProductRepository);
    }
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartService cartService(){
        return new CartService();
    }
    @Bean
    public UserService userService(IUserRepository userRepository){
        return new UserService(userRepository);
    }

    @Bean
    public RegistrationService registrationService(UserService userService, PasswordEncoder passwordEncoder){
        return new RegistrationService(userService, passwordEncoder);
    }

    @Bean
    public LoginService loginService(UserService userService){
        return new LoginService(userService);
    }

    @Bean
    public LogoutService logoutService(){
        return new LogoutService();
    };

}
