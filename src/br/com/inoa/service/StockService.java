package br.com.inoa.service;

import br.com.inoa.model.Stock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockService {

    public Stock create(String ticker, BigDecimal price) {
        return new Stock(ticker, price, LocalDateTime.now());
    }

    public Stock update(Stock stock, BigDecimal price) {
        stock.setLastUpdate(LocalDateTime.now());
        stock.setLastPrice(stock.getCurrentPrice());
        stock.setPrice(price);
        return stock;
    }

}
