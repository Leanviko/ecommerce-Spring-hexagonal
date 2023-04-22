package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.IStockRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.Stock;
import com.icodeap.ecommerce.infrastructure.mapper.IProductMapper;
import com.icodeap.ecommerce.infrastructure.mapper.IStockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepositoryImpl implements IStockRepository {

    private final IStockCrudRepository stockCrudRepository;
    private final IStockMapper stockMapper;
    private final IProductMapper productMapper;

    public StockRepositoryImpl(IStockCrudRepository stockCrudRepository, IStockMapper stockMapper, IProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }


    @Override
    public Stock saveStock(Stock stock) {
        return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockMapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }
}
