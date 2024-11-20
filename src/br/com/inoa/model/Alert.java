package br.com.inoa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Alert {

    private Stock stock;
    private BigDecimal triggerPrice;
    private LocalDateTime createdAt;
    private AlertType type;
    private AlertStatus status;
    private String message;

    public Alert() {}

    public Alert(Stock stock, BigDecimal triggerPrice, AlertType type, AlertStatus status, String message) {
        this.stock = stock;
        this.triggerPrice = triggerPrice;
        this.createdAt = LocalDateTime.now();
        this.type = type;
        this.status = status;
        this.message = message;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public BigDecimal getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AlertType getType() {
        return type;
    }

    public void setType(AlertType type) {
        this.type = type;
    }

    public AlertStatus getStatus() {
        return status;
    }

    public void setStatus(AlertStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
