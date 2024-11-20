package br.com.inoa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Stock {

    private String ticker;
    private BigDecimal price;
    private LocalDateTime lastUpdate;

    public Stock() {}

    public Stock(String ticker) {
        this.ticker = ticker;
    }

    public Stock(String ticker, BigDecimal price, LocalDateTime lastUpdate) {
        this.ticker = ticker;
        this.price = price;
        this.lastUpdate = lastUpdate;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
