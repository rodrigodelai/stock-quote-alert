package br.com.inoa;

import br.com.inoa.model.Alert;
import br.com.inoa.model.AlertStatus;
import br.com.inoa.model.AlertType;
import br.com.inoa.model.Stock;
import br.com.inoa.service.AlertService;
import br.com.inoa.service.MonitorService;
import br.com.inoa.service.StockService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class StockQuoteAlertApplication {

    public static void main(String[] args) {
        System.out.println("Stock Quote Alert works!");

        StockService stockService = new StockService();
        AlertService alertService = new AlertService();
        MonitorService monitorService = new MonitorService();

        Stock stock = stockService.create("PETR4", new BigDecimal("1000.00"));
        Alert alert = alertService.create(stock, new BigDecimal("800.00"), AlertType.BELOW);

        monitorService.startMonitor(alertService.list());

        System.out.println("Pressione qualquer tecla para encerrar o monitoramento...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        monitorService.stopMonitor();
        scanner.close();
    }

}