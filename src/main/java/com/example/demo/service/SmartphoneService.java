package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService {

    @PersistenceContext
    private EntityManager entityManager;

    private SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    public List<Smartphone> find3Newest() {
        return smartphoneRepository.findTop2ByOrderByBatteryCapacityDesc();
    }

    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Transactional
    public void update(Smartphone smartphone) {
        entityManager.merge(smartphone);
    }


    public void delete(Long id) {
        smartphoneRepository.deleteUsingNativeQuery(id);
    }
}
