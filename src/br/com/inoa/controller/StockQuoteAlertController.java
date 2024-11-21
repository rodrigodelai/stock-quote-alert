package br.com.inoa.controller;

import br.com.inoa.model.Alert;
import br.com.inoa.model.AlertType;
import br.com.inoa.model.Stock;
import br.com.inoa.service.AlertService;
import br.com.inoa.service.MonitorService;
import br.com.inoa.service.StockService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class StockQuoteAlertController {

    StockService stockService = new StockService();
    AlertService alertService = new AlertService();
    MonitorService monitorService = new MonitorService();

    public void createAlertFromCommandLineInput(String[] args) {
        Stock stock = stockService.create(args[0], new BigDecimal("22.60"));
        alertService.create(stock, new BigDecimal(args[1]), AlertType.ABOVE);
        alertService.create(stock, new BigDecimal(args[2]), AlertType.BELOW);
    }

    public void startMonitoringAlerts() {
        monitorService.startMonitor(alertService.list());
    }

    public void awaitUserInputToEnd() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        monitorService.stopMonitor();
        scanner.close();
    }

}
