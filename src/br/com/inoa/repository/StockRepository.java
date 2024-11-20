package br.com.inoa.repository;

import br.com.inoa.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockRepository {

    private final List<Stock> stocksInMemoryDatabase = new ArrayList<>();

    private void create(Stock stock) {
        stocksInMemoryDatabase.add(stock);
    }

    public List<Stock> findAll() {
        return stocksInMemoryDatabase;
    }

    public void delete(Stock stock) {
        stocksInMemoryDatabase.remove(stock);
    }

    public void deleteAll() {
        stocksInMemoryDatabase.clear();
    }

}
