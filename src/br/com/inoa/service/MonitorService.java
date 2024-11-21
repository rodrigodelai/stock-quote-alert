package br.com.inoa.service;

import br.com.inoa.model.Alert;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitorService {

    private final AlertService alertService = new AlertService();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Integer CHECK_INTERVAL_IN_SECONDS = 5;

    public void startMonitor(List<Alert> alerts) {
        System.out.println("Monitoramento iniciado.");

        Runnable initialTask = () -> {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Pressione qualquer tecla para encerrar o monitoramento.\n");
        };

        scheduler.scheduleAtFixedRate(initialTask, 0, CHECK_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);

        alerts.forEach(alert -> {
            Runnable task = () -> {
                if (alertService.checkAlert(alert)) {
                    System.out.println("ALERTA ACIONADO: " + alert.getStock().getTicker() + " atingiu R$ " + alert.getTriggerPrice() + ".");
                } else {
                    System.out.println(alert.getStock().getTicker() + ": R$ " + alert.getStock().getCurrentPrice() + " --- Target: " + alert.getType().toString().toLowerCase() + " R$ " + alert.getTriggerPrice());
                }
            };

            scheduler.scheduleAtFixedRate(task, 0, CHECK_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
        });
    }

    public void addAlert(Alert alert) {
        System.out.println("Alerta adicionado.");

        Runnable task = () -> {
            if (alertService.checkAlert(alert)) {
                    System.out.println("ALERTA ACIONADO: O preço de " + alert.getStock().getTicker() + " atingiu o valor de R$ " + alert.getTriggerPrice() + ".");
            } else {
                System.out.println(alert.getStock().getTicker() + ": R$ " + alert.getStock().getCurrentPrice() + " --- Target: " + alert.getType().toString().toLowerCase() + " R$ " + alert.getTriggerPrice());
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, CHECK_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
    }

    public void stopMonitor() {
        System.out.println("Monitoramento encerrado.");
        scheduler.shutdown();
    }

}
