package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.ProductService;
import com.icodeap.ecommerce.application.service.StockService;
import com.icodeap.ecommerce.domain.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {
    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("products",productService.getProducts());
        return "home";
    }
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model){
        List<Stock> stock = stockService.getStockByProduct(productService.getProductById(id));
        Integer lastBalance=0;
        try {
            lastBalance = stock.get(stock.size()-1).getBalance();
        }catch (Exception e){
            log.error("Producto sin stock");
        }


        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock",lastBalance);


        return "user/productdetail";
    }

    @GetMapping("/product-detail-admin/{id}")
    public String productDetailAdmin(@PathVariable Integer id, Model model){
        List<Stock> stock = stockService.getStockByProduct(productService.getProductById(id));
        Integer lastBalance = stock.get(stock.size()-1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock",lastBalance);


        return "admin/productdetail";
    }

}
