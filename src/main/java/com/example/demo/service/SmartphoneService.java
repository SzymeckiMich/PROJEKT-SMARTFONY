package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {

    private SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository){
        this.smartphoneRepository = smartphoneRepository;
    }

    public void save(Smartphone smartphone){
        smartphoneRepository.save(smartphone);
    }

    public List<Smartphone> find3Newest(){
        return smartphoneRepository.findTop2ByOrderByBatteryCapacityDesc();
    }

}
