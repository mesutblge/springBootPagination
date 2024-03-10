package com.demo.demo.services;

import com.demo.demo.dao.Alerts;
import com.demo.demo.dao.Scenarios;
import com.demo.demo.repository.ScenariosRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScenariosService {

    private final ScenariosRepository scenariosRepository;

    public ScenariosService(ScenariosRepository scenariosRepository) {
        this.scenariosRepository = scenariosRepository;
    }

    public void generateDummyScenario() {
        Faker faker=new Faker();
        for (int i = 1; i <= 15; i++) {
            Scenarios scenarios = new Scenarios();
            scenarios.setScenario_name("randomScenarioName" + i );
            scenarios.setIs_active(faker.bool().bool());
            scenariosRepository.save(scenarios);
        }
    }
    public List<Scenarios> getAllScenarios() {
        return scenariosRepository.findAll();
    }


}
