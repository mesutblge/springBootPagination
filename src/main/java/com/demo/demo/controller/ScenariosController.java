package com.demo.demo.controller;

import com.demo.demo.dao.Alerts;
import com.demo.demo.dao.Scenarios;
import com.demo.demo.services.AlertsService;
import com.demo.demo.services.ScenariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenariosController {
    private final ScenariosService scenariosService;

    public ScenariosController(ScenariosService scenariosService) {
        this.scenariosService = scenariosService;
    }

    @GetMapping("/getAllScenarios")
    public ResponseEntity<List<Scenarios>> getAllScenarios(){

        List<Scenarios> scenarios = scenariosService.getAllScenarios();
        System.out.println(scenarios);

        return new ResponseEntity<>(scenarios, HttpStatus.OK);

    }
    @GetMapping("/generateScenario")
    public void generatorScenario(){
        scenariosService.generateDummyScenario();
    }
}
