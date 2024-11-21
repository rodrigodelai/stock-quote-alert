package br.com.inoa.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Stock {

    private String ticker;
    private BigDecimal currentPrice;
    private BigDecimal lastPrice;
    private LocalDateTime lastUpdate;

    public Stock() {}

    public Stock(String ticker) {
        this.ticker = ticker;
    }

    public Stock(String ticker, BigDecimal currentPrice, LocalDateTime lastUpdate) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.lastPrice = currentPrice;
        this.lastUpdate = lastUpdate;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setPrice(BigDecimal price) {
        this.currentPrice = price.setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice.setScale(2, RoundingMode.HALF_DOWN);
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
