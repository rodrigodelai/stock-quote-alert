package br.com.inoa.repository;

import br.com.inoa.model.Alert;

import java.util.ArrayList;
import java.util.List;

public class AlertRepository {

    private final List<Alert> alertsInMemoryDatabase = new ArrayList<>();

    public Alert create(Alert alert) {
        alertsInMemoryDatabase.add(alert);
        return alert;
    }

    public List<Alert> findAll() {
        return alertsInMemoryDatabase;
    }

    public void delete(Alert alert) {
        alertsInMemoryDatabase.remove(alert);
    }

    public void deleteAll() {
        alertsInMemoryDatabase.clear();
    }

}
