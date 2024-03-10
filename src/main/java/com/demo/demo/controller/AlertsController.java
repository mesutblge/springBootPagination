package com.demo.demo.controller;

import com.demo.demo.dao.Alerts;
import com.demo.demo.repository.AlertsRepository;
import com.demo.demo.services.AlertsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class AlertsController {
    private final AlertsService alertsService;
    private final AlertsRepository alertsRepository;
    public AlertsController(AlertsService alertsService, AlertsRepository alertsRepository) {
        this.alertsService = alertsService;
        this.alertsRepository = alertsRepository;
    }



    @GetMapping("/getAllAlerts")
    public ResponseEntity<Page<Alerts>> getAllAlerts(
                                    @RequestParam(required = false) String alertName,
                                    Pageable pageable) {
        Page<Alerts> alerts = alertsService.getAllAlerts(alertName, pageable);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }
    @GetMapping("/customJoinQuery")
    public List<Object[]> getCustomJoinQueryResults() {
        return alertsRepository.joinQuery();
    }

    @GetMapping("/generateAlert")
    public void generator(){
        alertsService.generateDummyData();
    }
}
