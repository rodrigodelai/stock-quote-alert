package br.com.inoa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Alert {

    private String ticker;
    private BigDecimal triggerPrice;
    private LocalDateTime createdAt;
    private AlertType type;
    private AlertStatus status;
    private String message;

    public Alert() {}

    public Alert(String ticker, BigDecimal triggerPrice, AlertType type, String message) {
        this.ticker = ticker;
        this.triggerPrice = triggerPrice;
        this.createdAt = LocalDateTime.now();
        this.type = type;
        this.status = AlertStatus.ONLINE;
        this.message = message;
    }

    public Alert(String ticker, BigDecimal triggerPrice, String message, AlertStatus status, AlertType type) {
        this.ticker = ticker;
        this.triggerPrice = triggerPrice;
        this.createdAt = LocalDateTime.now();
        this.type = type;
        this.status = status;
        this.message = message;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
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
