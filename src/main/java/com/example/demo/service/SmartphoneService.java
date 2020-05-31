package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public List<Smartphone> findAllByOrderByModelAsc() {
        return smartphoneRepository.findAllByOrderByModelAsc();
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

    public List<Smartphone> findByProducer(Long id) {
        return smartphoneRepository.findByProducerId(id);
    }

    public List<Smartphone> find4Random() {
        List<Smartphone> randomSmartphones = new ArrayList<>();
        Random generator = new Random();
        int elements = (int) smartphoneRepository.count();

        for (int i = 0; i < 4; ) {
            Long id = (long) generator.nextInt(elements);
            Optional<Smartphone> smartphone = smartphoneRepository.findById(id);
            if (smartphone.isPresent() && !randomSmartphones.contains(smartphone.get())) {
                randomSmartphones.add(smartphone.get());
                i++;
            }
        }
        return randomSmartphones;
    }
}
