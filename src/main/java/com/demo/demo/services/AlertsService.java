package com.demo.demo.services;

import com.demo.demo.dao.Alerts;
import com.demo.demo.repository.AlertsRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

@Service
public class AlertsService {

    private final AlertsRepository alertsRepository;

    public AlertsService(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    public void generateDummyData() {
        for (int i = 1; i <= 100; i++) {
            Alerts alerts = new Alerts();
            alerts.setAlert_name("randomAlertName" + i );
            alerts.setCreated_time(new Date());
            alertsRepository.save(alerts);
        }
    }
    public Page<Alerts> getAllAlerts(String alertName, Pageable pageable) {
        return alertsRepository.findAll(pageable);
    }

}
