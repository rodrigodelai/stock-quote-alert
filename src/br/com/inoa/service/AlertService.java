package br.com.inoa.service;

import br.com.inoa.model.Alert;
import br.com.inoa.model.AlertStatus;
import br.com.inoa.model.AlertType;
import br.com.inoa.model.Stock;
import br.com.inoa.repository.AlertRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AlertService {

    private final AlertRepository alertRepository = new AlertRepository();
    private final StockService stockService = new StockService();
    private final String STANDARD_MESSAGE_ALERT_TRIGGER = "Mensagem padrão.";

    public Boolean checkAlert(Alert alert) {
        if (alert.getStatus() == AlertStatus.ONLINE) {
            if (alert.getType() == AlertType.ABOVE) {
                return alert.getStock().getCurrentPrice().compareTo(alert.getTriggerPrice()) >= 0 &&
                       alert.getStock().getLastPrice().compareTo(alert.getTriggerPrice()) <= 0;
            }
            else if (alert.getType() == AlertType.BELOW) {
                return alert.getStock().getCurrentPrice().compareTo(alert.getTriggerPrice()) <= 0 &&
                       alert.getStock().getLastPrice().compareTo(alert.getTriggerPrice()) >= 0;
            }
        }
        return false;
    }

    public Alert create(Stock stock, BigDecimal triggerPrice, AlertType type) {
        return alertRepository.create(new Alert(stock, triggerPrice, type, AlertStatus.ONLINE, STANDARD_MESSAGE_ALERT_TRIGGER));
    }

    public Alert create(Stock stock, BigDecimal triggerPrice, AlertType type, AlertStatus status, String message) {
        return alertRepository.create(new Alert(stock, triggerPrice, type, status, message));
    }

    public List<Alert> list() {
        return alertRepository.findAll();
    }

    public Alert update(Alert alert, BigDecimal triggerPrice, AlertType type, AlertStatus status, String message) {
        alert.setTriggerPrice(triggerPrice);
        alert.setType(type);
        alert.setStatus(status);
        alert.setMessage(message);
        return alert;
    }

    public Alert toggleStatus(Alert alert) {
        alert.setStatus(alert.getStatus() == AlertStatus.ONLINE ? AlertStatus.OFFLINE : AlertStatus.ONLINE);
        return alert;
    }

    public void delete(Alert alert) {
        alertRepository.delete(alert);
    }

}
