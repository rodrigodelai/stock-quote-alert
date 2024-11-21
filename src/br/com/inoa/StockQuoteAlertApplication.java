package br.com.inoa;

import br.com.inoa.controller.StockQuoteAlertController;

public class StockQuoteAlertApplication {

    public static void main(String[] args) {
        StockQuoteAlertController controller = new StockQuoteAlertController();
        controller.createAlertFromCommandLineInput(args);
        controller.startMonitoringAlerts();
        controller.awaitUserInputToEnd();
    }

}