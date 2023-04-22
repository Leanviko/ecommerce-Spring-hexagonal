package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.IStockRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.Stock;

import java.util.List;

public class StockService {
    private final IStockRepository stockRepository;

    public StockService(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public Stock saveStock(Stock stock){
        return stockRepository.saveStock(stock);
    }
    public List<Stock> getStockByProduct(Product product){
        return stockRepository.getStockByProduct(product);
    }
}
