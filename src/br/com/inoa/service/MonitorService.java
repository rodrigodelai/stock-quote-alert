package br.com.inoa.service;

import br.com.inoa.model.Alert;
import br.com.inoa.model.AlertStatus;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitorService {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Integer CHECK_INTERVAL_IN_SECONDS = 5;
    private Integer contador = 1;

    public void startMonitor(List<Alert> alerts) {
        System.out.println("Monitoramento iniciado.");

        alerts.forEach(alert -> {
            Runnable task = () -> {
                if (alert.getStatus() == AlertStatus.ONLINE) {
                    System.out.println(contador + " - TAREFA EXECUTADA. MESSAGEM: " + alert.getMessage());
                }
                this.contador++;
            };

            scheduler.scheduleAtFixedRate(task, 0, CHECK_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
        });
    }

    public void addAlert(Alert alert) {
        System.out.println("Alerta adicionado.");

        Runnable task = () -> {
            if (alert.getStatus() == AlertStatus.ONLINE) {
                System.out.println("TAREFA EXECUTADA. MESSAGEM: " + alert.getMessage());
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
    }

    public void stopMonitor() {
        System.out.println("Monitoramento encerrado.");
        scheduler.shutdown();
    }

}
